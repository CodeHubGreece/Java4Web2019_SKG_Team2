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
    //let amkaC = document.getElementById('amkaC').value;
    let doctorId = document.getElementById("doctorId").value;
    let date = document.getElementById('date').value;
    let time = document.getElementById('time').value;
    let illnessDescription = document.getElementById('illnessDescription').value;
    let comments = document.getElementById('comments').value;
    let amkaC = "56452859521";
    date = formatDate(date);
    console.log(date);
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