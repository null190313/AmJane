$("#loginSumbit").click(function () {
    $(".errorInfoLogin span").text();
    $(".errorInfoLogin").css("visibility", "hidden");
    $.post(EntryGlobalLocation+"userLogin.do",$("#loginForm").serialize(),function (data) {
        if(-1 == data.detectionCode){
            $("#accountError").text(data.detectionMessage);
            $("#accountError").css("visibility", "visible");
        }else if(-2 == data.detectionCode){
            $("#passwordError").text(data.detectionMessage);
            $("#passwordError").css("visibility", "visible");
        }else if(0 == data.detectionCode){
            window.location.href = CenterLocation+"persional.html";
        }
    })

})
