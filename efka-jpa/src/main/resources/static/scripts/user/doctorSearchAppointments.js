$(document).ready(function() {
    let url = new URL(window.location.href);
    let fromDate = url.searchParams.get("fromDate");
    let toDate = url.searchParams.get("toDate");
    let illnessDescription = url.searchParams.get("illnessDescription");

    if(fromDate!==null && toDate!==null && illnessDescription===null){
        fromDate = formatDate(fromDate);
        toDate = formatDate(toDate);
        $.ajax({
            url: ROOT_PATH + '/pages/user/doctor/doctorSearchResults',
            type: 'GET',
            data: {
                fromDate: fromDate,
                toDate: toDate
            },
            contentType: 'application/json',
            async: false,
            success: function (appointments) {
                let result = getByDoctor(appointments);
                populateDataTable(result);
            },
            error: function (text) {
                alert("ERROR: " + text);
            }
        });
    } else if(fromDate===null && toDate===null && illnessDescription!==null){
        $.ajax({
            url: ROOT_PATH + '/pages/user/doctor/doctorSearchResults',
            type: 'GET',
            data: {
                illnessDescription: illnessDescription
            },
            contentType: 'application/json',
            async: false,
            success: function (appointments) {
                let result = getByDoctor(appointments);
                populateDataTable(result);
            },
            error: function (text) {
                alert("ERROR: " + text);
            }
        });
    } else if(fromDate!==null && toDate!==null && illnessDescription!==null){
        fromDate = formatDate(fromDate);
        toDate = formatDate(toDate);
        $.ajax({
                url: ROOT_PATH + '/pages/user/doctor/doctorSearchResults',
                type: 'GET',
                data: {
                    fromDate: fromDate,
                    toDate: toDate,
                    illnessDescription: illnessDescription
                },
                contentType: 'application/json',
                async: false,
                success: function (appointments) {
                    let result = getByDoctor(appointments);
                    populateDataTable(result);
                },
                error: function (text) {
                    alert("ERROR: " + text);
                }
        });
    }
} );

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

function getByDoctor(appointments){
    let doctorId = sessionStorage.getItem("userid");
    let result = [];
    for(let i=0; i<appointments.length; i++){
        if(appointments[i].doctors.doctorId===doctorId){
            result.push(appointments[i]);
        }
    }
    return result;
}

function populateDataTable(appointments) {
    $("#doctorsTable").append("<tbody>");
    jQuery.each(appointments, function(i,appointment) {
        $("#doctorsTable").append("<tr id='appointmentsRow" + appointment.appointmentId + "'><td style=\"width: 15%\">" + '<div class="dropdown"><button onclick="show('
         +appointment.appointmentId+' )" class="btn btn-primary btn-block">Στοιχεία ασθενή</button></div>'
         + '<div id="' + appointment.appointmentId + '" class="dropdown-content" style="display: none">'
         + "<p style= 'margin-top:5px; margin-bottom: auto;'><b>Ονοματεπώνυμο:</b> " + appointment.doctors.lastName + " " + appointment.doctors.firstName
         + "<br>"
         + "<b>Email:</b> " + appointment.citizens.email
         + "<br>"
         + "<b>Τηλέφωνο:</b> " + appointment.citizens.phone
         + '</p></div>'
         + "</td><td>" + appointment.date + "</td><td>" + appointment.time + "</td><td>"
        + appointment.illnessDescription + "</td><td>" + appointment.comments + "</td></tr>");
     });
     $("#doctorsTable").append("</tbody>");
    $('#doctorsTable').DataTable();

}

function show(id){
    if(document.getElementById(id).style.display === "none"){
        document.getElementById(id).style.display = "block";
        document.getElementById("td" + id).style.width = "20%";
    } else{
        document.getElementById(id).style.display = "none";
        document.getElementById("td" + id).style.width = "15%";
    }
}