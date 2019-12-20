$(document).ready(function() {
    let url = new URL(window.location.href);
    let fromDate = url.searchParams.get("fromDate");
    let toDate = url.searchParams.get("toDate");
    let specialtyId = url.searchParams.get("specialtyId");

    fromDate = formatDate(fromDate);
    toDate = formatDate(toDate);
    $.ajax({
        url: ROOT_PATH + '/pages/user/citizen/searchResults',
        type: 'GET',
        data: {
            specialtyId: specialtyId,
            fromDate: fromDate,
            toDate: toDate
        },
        contentType: 'application/json',
        async: false,
        success: function (appointments) {
            let result = getByCitizen(appointments);
            populateDataTable(result);
        },
        error: function (text) {
            alert("ERROR: " + text);
        }
    });
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

function getByCitizen(appointments){
    let citizenId = sessionStorage.getItem("userid");
    let result = [];
    for(let i=0; i<appointments.length; i++){
        if(appointments[i].citizens.amka===citizenId){
            result.push(appointments[i]);
        }
    }
    return result;
}

function populateDataTable(appointments) {
    $("#citizensTable").append("<tbody>");
    jQuery.each(appointments, function(i,appointment) {
        $("#citizensTable").append("<tr id='appointmentsRow" + appointment.appointmentId + "'><td id=\"td" + appointment.appointmentId + "\" style=\"width: 15%\">"
            + '<div class="dropdown"><button onclick="show(' +appointment.appointmentId+' )" class="btn btn-primary btn-block">Στοιχεία γιατρού</button></div>'
            + '<div id="' + appointment.appointmentId + '" class="dropdown-content" style="display: none">'
            + "<p style= 'margin-top:5px; margin-bottom: auto;'><b>Ονοματεπώνυμο:</b> " + appointment.doctors.lastName + " " + appointment.doctors.firstName
            + "<br>"
            + "<b>Ειδικότητα:</b> " + appointment.doctors.specialties.specialty
            + '</p></div>'
            + "</td><td>" + appointment.date + "</td><td>" + appointment.time + "</td><td>"
            + appointment.illnessDescription + "</td><td>" + appointment.comments + "</td><td>"
            + '<div class="dropdown"><button onclick="showUpdate(' + appointment.appointmentId + ')" id="update' + appointment.appointmentId + '" class="btn btn-success" style=\"width: 100%\">Ενημέρωση</button></div>'
            + "</td><td>"
            + '<div class="dropdown"><button id="delete' + appointment.appointmentId + '" onclick="deleteRow(' + appointment.appointmentId + ')" class="btn btn-danger" style=\"width: 100%\">Διαγραφή</button></div>'
            + "</td></tr>");
     });
     $("#citizensTable").append("</tbody>");
    $('#citizensTable').DataTable();

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

function deleteRow(appointmentsId){
    $("#citizensTable").on('click', function(event){
        $.ajax({
            url: ROOT_PATH + "/appointments/delete/" + appointmentsId,
            type : "DELETE",
            dataType : 'json',
            contentType: 'application/json',
                success : function(result) {
                    $("#appointmentsRow" + appointmentsId).remove();
                    $("input[name=fromDate]").val("");
                    $("input[name=toDate]").val("");
                    $("input[name=illnessDescription]").val("");
                    $("input[name=comments]").val("");
                    $("#appointmentsRow" + appointmentsId).dataTable().fnDraw();
                },
                error: function(xhr, resp, text) {
                    console.log(xhr, resp, text);
                    alert("Could not delete appointment!");
                 }
         })
    });
    location.reload();
}

async function showUpdate(appointmentsId){
    document.getElementById("updateAppointment").style.display = "block";
    let button = document.getElementById("updateButton");
    button.onclick = await function(){updateRow(appointmentsId);};
}

async function updateRow(appointmentsId){
    let date = document.getElementById("date").value;
    let time = document.getElementById("time").value;
    time += ":00";
    date = formatDate(date);
    $.ajax({
        url: ROOT_PATH + "/appointments/update/" + appointmentsId,
        type : "PUT",
        dataType : 'json',
        data: JSON.stringify({
            "date": date,
            "time": time
        }),
        contentType: 'application/json',
            success : function(result) {
//                    $("#appointmentsRow" + appointmentsId).remove();
//                    $("input[name=fromDate]").val("");
//                    $("input[name=toDate]").val("");
//                    $("input[name=illnessDescription]").val("");
//                    $("input[name=comments]").val("");
//                    $("#appointmentsRow" + appointmentsId).dataTable().fnDraw();
                location.reload();
            },
            error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
                alert("Could not update appointment!");
             }
     })
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