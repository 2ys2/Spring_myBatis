/*file.js*/
var uploadResult = $(".uploadResult ul");

function showUploadedFile(uploadResultArr){
    var str ="";

    $(uploadResultArr).each(function(i, obj) {
    
   
    //if(!obj.image){
    //    str += "<li><img src='/resources/img/attach.png'>"+obj.fileName+"</li>";
    //} else {
    
        /* str += "<li>/" + obj.fileName +  "</li>" ; */
        console.log(i);
        console.log(obj);

        var fileCallPath = encodeURIComponent( obj.uploadPath+"/s_"+obj.uuid+"_"+obj.fileName);
        str += "<li><img src='./display?fileName="+fileCallPath+"'></li>";
   // }
    });
    uploadResult.append(str);
}


$(document).ready(function () {
    var cloneObj = $(".uploadDiv").clone();
    $("#uploadBtn").on("click", function (e) {
        var formData = new FormData();
        var inputFile = $("input[name='uploadFile']");
        var files = inputFile[0].files;
        console.log(files);

        //add File Data to formData
        for (var i = 0; i < files.length; i++) {
            formData.append("uploadFile", files[i]);

        }

        $.ajax({
            url: './uploadAjaxAction',
            processData: false,
            contentType: false,
            data: formData,
            type: 'POST',
            dataType : 'json',
            success: function (result) {
                alert("Uploaded");
                console.log(result);
                showUploadedFile(result);
                $(".uploadDiv").html(cloneObj.html());
            }
        }); //$.ajax


    });
});

