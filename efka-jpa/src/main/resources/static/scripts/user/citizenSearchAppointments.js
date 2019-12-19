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
        $("#citizensTable").append("<tr id='appointmentsRow" + appointment.appointmentId + "'><td>"
            + '<div class="dropdown"><button onclick="show(' +appointment.appointmentId+' )" class="dropbtn">Doctor details</button></div>'
            + '<div id="' + appointment.appointmentId + '" class="dropdown-content" style="display: none">'
            + "<p>Ονοματεπώνυμο: " + appointment.doctors.lastName + " " + appointment.doctors.firstName
            + "<br>"
            + "Ειδικότητα: " + appointment.doctors.specialties.specialty
            + '</p></div>'
            + "</td><td>" + appointment.date + "</td><td>" + appointment.time + "</td><td>"
            + appointment.illnessDescription + "</td><td>" + appointment.comments + "</td><td>"
            + '<div class="dropdown"><button onclick="show(' +appointment.appointmentId+' )" class="dropbtn">Update</button></div>'
            + '<div id="' + appointment.appointmentId + '" class="dropdown-content" style="display: none">'
            + "<p>Ονοματεπώνυμο: " + appointment.citizens.lastName + " " + appointment.citizens.firstName
            + "<br>"
            + "Email: " + appointment.citizens.email
            + "<br>"
            + "Τηλέφωνο: " + appointment.citizens.phone
            + '</p></div>' + "</td><td>"
            + '<div class="dropdown"><button onclick="show(' +appointment.appointmentId+' )" class="dropbtn">Delete</button></div>'
            + '<div id="' + appointment.appointmentId + '" class="dropdown-content" style="display: none">'
            + "<p>Ονοματεπώνυμο: " + appointment.citizens.lastName + " " + appointment.citizens.firstName
            + "<br>"
            + "Email: " + appointment.citizens.email
            + "<br>"
            + "Τηλέφωνο: " + appointment.citizens.phone
            + '</p></div>'
            + "</td></tr>");
     });
     $("#citizensTable").append("</tbody>");
    $('#citizensTable').DataTable();

}

function show(id){
    if(document.getElementById(id).style.display === "none"){
        document.getElementById(id).style.display = "block";
    } else{
        document.getElementById(id).style.display = "none";
    }
}


//$(document).ready(function() {
//    editor = new $.fn.dataTable.Editor( {
//        "ajax": "../../../ajax/data/appointments.txt",
//        "table": "#example",
//        "fields": [ {
//                "label": "First name:",
//                "name": "first_name"
//            }, {
//                "label": "Last name:",
//                "name": "last_name"
//            }, {
//                "label": "Position:",
//                "name": "position"
//            }, {
//                "label": "Office:",
//                "name": "office"
//            }, {
//                "label": "Extension:",
//                "name": "extn"
//            }, {
//                "label": "Start date:",
//                "name": "start_date",
//                "type": "datetime"
//            }, {
//                "label": "Salary:",
//                "name": "salary"
//            }
//        ]
//    } );
//
//    // New record
//    $('a.editor_create').on('click', function (e) {
//        e.preventDefault();
//
//        editor.create( {
//            title: 'Create new record',
//            buttons: 'Add'
//        } );
//    } );
//
//    // Edit record
//    $('#example').on('click', 'a.editor_edit', function (e) {
//        e.preventDefault();
//
//        editor.edit( $(this).closest('tr'), {
//            title: 'Edit record',
//            buttons: 'Update'
//        } );
//    } );
//
//    // Delete a record
//    $('#example').on('click', 'a.editor_remove', function (e) {
//        e.preventDefault();
//
//        editor.remove( $(this).closest('tr'), {
//            title: 'Delete record',
//            message: 'Are you sure you wish to remove this record?',
//            buttons: 'Delete'
//        } );
//    } );
//
//    $('#example').DataTable( {
//        ajax: "../php/staff.php",
//        columns: [
//            { data: null, render: function ( data, type, row ) {
//                // Combine the first and last names into a single table field
//                return data.first_name+' '+data.last_name;
//            } },
//            { data: "position" },
//            { data: "office" },
//            { data: "extn" },
//            { data: "start_date" },
//            { data: "salary", render: $.fn.dataTable.render.number( ',', '.', 0, '$' ) },
//            {
//                data: null,
//                className: "center",
//                defaultContent: '<a href="" class="editor_edit">Edit</a> / <a href="" class="editor_remove">Delete</a>'
//            }
//        ]
//    } );
//} );