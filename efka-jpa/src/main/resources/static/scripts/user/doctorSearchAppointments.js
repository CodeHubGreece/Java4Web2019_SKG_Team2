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

function insertToDataTable(result){
   var table = $('#doctorsTable').DataTable( {
       "data": result,
       "columns": [
           {
               "className":      'details-control',
               "orderable":      false,
               "data":           null,
               "defaultContent": ''
           },
           { "data": "date" },
           { "data": "time" },
           { "data": "illnessDescription" },
           { "data": "comments" }
       ],
       "order": [[1, 'asc']]
   } );


   // Add event listener for opening and closing details
   $('#doctorsTable tr').on('click', 'td.details-control', function () {
//       var tr = $(this).closest('tr');
       console.log(this.id )
       var row = table.row( tr );
       if ( row.child.isShown() ) {
           // This row is already open - close it
           row.child.hide();
           tr.removeClass('shown');
       }
       else {
           // Open this row
           row.child( format(result[0].citizens)).show();
           tr.addClass('shown');
       }
   } );
}

function populateDataTable(appointments) {
    $("#doctorsTable").append("<tbody>");
    jQuery.each(appointments, function(i,appointment) {
        $("#doctorsTable").append("<tr id='appointmentsRow" + appointment.appointmentId + "'><td>" + '<div class="dropdown"><button onclick="show('
         +appointment.appointmentId+' )" class="dropbtn">Citizen details</button></div>'
         + '<div id="' + appointment.appointmentId + '" class="dropdown-content" style="display: none">'
         + "<p>Ονοματεπώνυμο: " + appointment.citizens.lastName + " " + appointment.citizens.firstName
         + "<br>"
         + "Email: " + appointment.citizens.email
         + "<br>"
         + "Τηλέφωνο: " + appointment.citizens.phone
         + '</p>'
         + "</td><td>" + appointment.date + "</td><td>" + appointment.time + "</td><td>"
        + appointment.illnessDescription + "</td><td>" + appointment.comments + "</td></tr>");
     });
     $("#doctorsTable").append("</tbody>");
//     $("#doctorsTable tr").click(function() {
////        loadBook($(this).children("td").html());
//        //console.log($(this).children("td").html());
//     });
    $('#doctorsTable').DataTable();

}

//function loadBook(id) {
//    $.ajax({
//        url: ROOT_PATH + "/appointments/" + id
//    }).then(function(appointment) {
//       $("input[name=id]").val(appointment.appointmentId);
//       $("input[name=date]").val(appointment.date);
//       $("input[name=time]").val(appointment.time);
//    });
//};

function show(id){
    if(document.getElementById(id).style.display === "none"){
        document.getElementById(id).style.display = "block";
    } else{
        document.getElementById(id).style.display = "none";
    }
}