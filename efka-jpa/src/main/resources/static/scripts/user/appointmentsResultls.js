import 'datatables/media/css/jquery.dataTables.css';
import 'datatables';

$(document).ready(function() {
//    $('#doctorsTable').DataTable( {
//        $.ajax({
//            url: ROOT_PATH + '/appointments/search/illness',
//            type: 'GET',
//            data: {
//                illnessDescription: "sick",
//                doctorId: "59421"
//            },
//            contentType: 'application/json',
//            async: false,
//            success: function (appointments) {
//                successFlag = true;
//                /*let doctorsOptions = '<option value="" disabled selected>--Γιατρός--</option>';
//                for(let i=0; i<doctors.length; i++){
//                    doctorsOptions += '<option value="' + doctors[i].doctorId + '">' + doctors[i].lastName + ' ' + doctors[i].firstName + '</option>';
//                }
//                document.getElementById("doctorId").innerHTML = doctorsOptions;*/
//                console.log(appointments);
//            },
//            error: function (text) {
//                alert("ERROR: " + text);
//            }
//        });
//    } );
    "ajax": {
        "Date": "12-11-2019",
        "Time": "14:00",
        "Illness Description": "sick",
        "Comments": "dsdgdsg"
    }
} );