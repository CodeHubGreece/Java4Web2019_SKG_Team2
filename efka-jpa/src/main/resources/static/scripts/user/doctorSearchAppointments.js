
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
    console.log(details);
    var table = $('#doctorsTable').DataTable( {
        "data": details,
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
} );