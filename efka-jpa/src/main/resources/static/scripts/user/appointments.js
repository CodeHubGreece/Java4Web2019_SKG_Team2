function getDoctorsBySpecialty(){
    let specialtyId = document.getElementById("specialtyId").value;

    $.ajax({
            url: ROOT_PATH + '/get_specialty/' + specialtyId,
            type: 'GET',
            dataType: 'json',
            data: specialtyId,
            contentType: 'application/json',
            success: function (doctors) {
                let doctorsOptions = '<option value="" disabled selected>--Γιατρός--</option>';
                for(let i=0; i<doctors.length; i++){
                    doctorsOptions += '<option value="' + doctors[i].doctorId + '">' + doctors[i].lastName + ' ' + doctors[i].firstName + '</option>';
                }
                document.getElementById("doctorId").innerHTML = doctorsOptions;
            },
            error: function (text) {
                alert("ERROR: " + text);
            }
    });
}

function createAppointment(){
    let amkaC = sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME);
    let doctorId = document.getElementById("doctorId").value;
    let date = document.getElementById('date').value;
    let time = document.getElementById('time').value;
    let illnessDescription = document.getElementById('illnessDescription').value;
    let comments = document.getElementById('comments').value;
    date = formatDate(date);
    time += ":00";

     $.ajax({
            url: ROOT_PATH + '/appointments/create',
            type: 'POST',
            dataType: 'json',
            data: JSON.stringify({
                "amkaC": amkaC,
                "doctorId": doctorId,
                "date": date,
                "time": time,
                "illnessDescription": illnessDescription,
                "comments": comments
            }),
            contentType: 'application/json',
            success: function () {
                alert("Appointment Created");
            },
            error: function (error) {
                alert("Error with appointment creation: " + error);
            }
        });
}

function searchAppointmentsCitizen(){
    let specialtyId = document.getElementById("specialtyIdSearch").value;
    let fromDate = document.getElementById("fromDate").value;
    let toDate = document.getElementById("toDate").value;
    let amka = sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME);

    fromDate = formatDate(fromDate);
    toDate = formatDate(toDate);


        $.ajax({
                url: ROOT_PATH + '/appointments/search/date_specialty',
                type: 'GET',
                data: {
                    specialtyId: specialtyId,
                    fromDate: fromDate,
                    toDate: toDate,
                    amka: amka
                },
                contentType: 'application/json',
                success: function (appointments) {
                    /*let doctorsOptions = '<option value="" disabled selected>--Γιατρός--</option>';
                    for(let i=0; i<doctors.length; i++){
                        doctorsOptions += '<option value="' + doctors[i].doctorId + '">' + doctors[i].lastName + ' ' + doctors[i].firstName + '</option>';
                    }
                    document.getElementById("doctorId").innerHTML = doctorsOptions;*/
                    console.log(appointments);
                },
                error: function (text) {
                    alert("ERROR: " + text);
                }
        });

}

async function searchAppointmentsDoctor(){
    let fromDate = document.getElementById("fromDate").value;
    let toDate = document.getElementById("toDate").value;
    let illnessDescription = document.getElementById("illnessDescription").value;
    let doctorId = sessionStorage.getItem(SESSION_STORAGE_LOGIN_TOKEN_NAME);

    let successFlag = false;
    let details = [];

    if(fromDate==""){fromDate=null;}
    if(toDate==""){toDate=null;}
    if(illnessDescription==""){illnessDescription=null;}

    if(fromDate!==null && toDate!==null && illnessDescription===null){
    fromDate = formatDate(fromDate);
    toDate = formatDate(toDate);
        $.ajax({
            url: ROOT_PATH + '/appointments/search/date',
            type: 'GET',
            data: {
                fromDate: fromDate,
                toDate: toDate,
                doctorId: doctorId
            },
            contentType: 'application/json',
            async: false,
            success: function (appointments) {
                successFlag = true;
                getDetails(appointments);
            },
            error: function (text) {
                alert("ERROR: " + text);
            }
        });
    } else if(fromDate===null && toDate===null && illnessDescription!==null){
        $.ajax({
            url: ROOT_PATH + '/appointments/search/illness',
            type: 'GET',
            data: {
                illnessDescription: illnessDescription,
                doctorId: doctorId
            },
            contentType: 'application/json',
            async: false,
            success: function (appointments) {
                successFlag = true;
                getDetails(appointments);
            },
            error: function (text) {
                alert("ERROR: " + text);
            }
        });
    } else if(fromDate!==null && toDate!==null && illnessDescription!==null){
        fromDate = formatDate(fromDate);
        toDate = formatDate(toDate);
        $.ajax({
                url: ROOT_PATH + '/appointments/search/date_illness',
                type: 'GET',
                data: {
                    fromDate: fromDate,
                    toDate: toDate,
                    illnessDescription: illnessDescription,
                    doctorId: doctorId
                },
                contentType: 'application/json',
                async: false,
                success: function (appointments) {
                    successFlag = true;
                    getDetails(appointments);
                },
                error: function (text) {
                    alert("ERROR: " + text);
                }
        });
    } else{
        alert("Please fill in the dates, the illness or both");
    }
    if(successFlag){
        window.location.replace(ROOT_PATH + "/pages/user/doctor/doctorSearchResults.html");
    }

}

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}

function getDetails(appointments){
    let details = [];
    for(let i=0; i<appointments.length; i++){
        details.push({
          "date": appointments[i].date,
          "time": appointments[i].time,
          "illnessDescription": appointments[i].illnessDescription,
          "comments": appointments[i].comments,
          "fullname": appointments[i].citizens.lastName + " " + appointments[i].citizens.firstName,
          "email": appointments[i].citizens.email,
          "phone": appointments[i].citizens.phone
        });
    }
    console.log(details);
    sessionStorage.setItem("appointmentsDetails", JSON.stringify(details));
}