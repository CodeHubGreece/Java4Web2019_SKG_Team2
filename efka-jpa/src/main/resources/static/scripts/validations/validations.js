$(document).ready(function () {

    $("form:not([data-enable-validation]) input").on("keyup change focus", function () {
        try {
            const closestForm = $(this).closest("form");
            if (!closestForm.length) {
                console.warn("Submit button is undefined.");
                return;
            }
            
            // Enable / Disable submit button
            const submitButton = $(closestForm).find("[type='button'],button");
            if (!submitButton.length) {
                console.warn("Submit button is undefined.");
                return;
            }
            
            const isFormValid = $(closestForm)[0].checkValidity();
    
            submitButton.attr("disabled", !isFormValid);

             // Show / Hide error label
             const errorLabel = $(this).closest(".form-group").find(".error-label");
             if (!errorLabel.length) {
                 console.warn("Error label is undefined.");
                 return;
             }
 
             const isCurrentTargetValid = $(this).is(":valid");
             if (!isCurrentTargetValid) {
                 $(errorLabel).show();
             } else {
                 $(errorLabel).hide();
             }
        }catch(e) {
            console.error(e);
        }
    });

})