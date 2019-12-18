
/* Formatting function for row details - modify as you need */
function format ( d ) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td>Ονοματεπώνυμο:</td>'+
            '<td>'+d.fullname+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Email:</td>'+
            '<td>'+d.email+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Τηλέφωνο:</td>'+
            '<td>'+d.phone+'</td>'+
        '</tr>'+
    '</table>';
}


$(document).ready(function() {
    let details = JSON.parse(sessionStorage.getItem("appointmentsDetails"));
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
                insertToDataTable(result);
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
                insertToDataTable(result);
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
                    insertToDataTable(result);
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
   $('#doctorsTable tbody').on('click', 'td.details-control', function () {
       var tr = $(this).closest('tr');
       var row = table.row( tr );

       if ( row.child.isShown() ) {
           // This row is already open - close it
           row.child.hide();
           tr.removeClass('shown');
       }
       else {
           // Open this row
           row.child( format(row.data()) ).show();
           tr.addClass('shown');
       }
   } );
}