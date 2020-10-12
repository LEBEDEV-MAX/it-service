$(document).ready(function(){
    var task = $('select').val();;

    $('select').change(function(){
        task = $('select').val();

        if (task == 'twoArrays') {
            $('.twoArrayBlock').show();
            $('.expandedFormBlock').hide();
        } else if (task == 'expandedForm') {
            $('.twoArrayBlock').hide();
            $('.expandedFormBlock').show();
        }
    });

    $('#saveButton').click(function(){
        var inputs;

        if (task == 'twoArrays') {
            input = {
                array_1: $('#array_1').val(),
                array_2: $('#array_2').val()
            };
        } else if (task == 'expandedForm') {
            input = $('#number').val();
        }

        $.ajax({
            method: 'POST',
            url: '/save',
            data: {
                task: task,
                input: input
            },
            success: function (data) {
                var link = document.createElement('a');
                link.href = data;
                link.download = data;
                link.click();
            },
        });
    });
 });