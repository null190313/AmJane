var BlogLocation;
var CenterLocation;
var CloudLocation;
var DiaryLocation;
var EntryGlobalLocation;
var LogsLocation;
var NovelLocation;
var SharingLocation;

window.onload = function () {
    BlogLocation = $("#BlogLocation").val();
    CenterLocation = $("#CenterLocation").val();
    CloudLocation = $("#CloudLocation").val();
    DiaryLocation = $("#DiaryLocation").val();
    EntryGlobalLocation = $("#EntryGlobalLocation").val();
    LogsLocation = $("#LogsLocation").val();
    NovelLocation = $("#NovelLocation").val();
    SharingLocation = $("#SharingLocation").val();
}

/*60S倒计时*/
var countdown = 60;

function settime() {
    if (countdown == 0) {
        $("#achieveRegisCode").attr("disabled", false);
        $("#achieveRegisCode").attr("value", "免费获取验证码");
        $("#achieveRegisCode").css("background-color", "#fb593f");
        countdown = 60;
    } else {
        $("#achieveRegisCode").attr("disabled", true);
        $("#achieveRegisCode").attr("value", "重新发送(" + countdown + ")");
        countdown--;
        setTimeout(settime, 1000)
    }
}

/*===============================================Register===============================================*/
/*用户注册获取注册验证码 6位数*/
$("#achieveRegisCode").click(function () {
    $(".errorInfoCla span").text();
    $(".errorInfoCla").css("visibility", "hidden");
    $.get(EntryGlobalLocation + "checkInfoIsRepeat.do", {
        nickName: "",
        firstPassword: "",
        secondPassword: "",
        userPhone: $("#regPhone").val()
    }, function (data) {
        if (-2 == data.detectionCode) {
            $("#phoneError").text(data.detectionMessage);
            $("#phoneError").css("visibility", "visible");
        } else if (2 == data.detectionCode) {
            $("#phoneError").css("visibility", "hidden");
            $.get(EntryGlobalLocation + "achieveSMSCheckInfo.do", {
                nickName: $("#regUserNickName").val(),
                firstPassword: $("#regUserFirstPassword").val(),
                secondPassword: $("#regUserSecondPassword").val(),
                userPhone: $("#regPhone").val()
            }, function (data) {
                if (-1 == data.detectionCode) {
                    $("#nickError").text(data.detectionMessage);
                    $("#nickError").css("visibility", "visible");
                } else if (-2 == data.detectionCode) {
                    $("#passFirstError").text(data.detectionMessage);
                    $("#passFirstError").css("visibility", "visible");
                } else if (-3 == data.detectionCode) {
                    $("#passSecondError").text(data.detectionMessage);
                    $("#passSecondError").css("visibility", "visible");
                } else if (-4 == data.detectionCode) {
                    $("#phoneError").text(data.detectionMessage);
                    $("#phoneError").css("visibility", "visible");
                } else {
                    $.get(EntryGlobalLocation + "sendSMS.do", {phone: $("#regPhone").val()}, function (data, status) {
                        if (1 == data.detectionCode) {
                            //TODO修改按钮
                            $("#achieveRegisCode").css("background-color", "#cccccc");
                            settime();
                        }
                    });
                }
            });
        }
    })


});
/*用户名校验是否重复*/
$("#regUserNickName").blur(function () {
    $(".errorInfoCla span").text();
    $(".errorInfoCla").css("visibility", "hidden");
    $.get(EntryGlobalLocation + "checkInfoIsRepeat.do", {
        nickName: $("#regUserNickName").val(),
        firstPassword: "",
        secondPassword: "",
        userPhone: ""
    }, function (data) {
        if (-1 == data.detectionCode) {
            $("#nickError").text(data.detectionMessage);
            $("#nickError").css("visibility", "visible");
        } else if (1 == data.detectionCode) {
            $("#nickError").css("visibility", "hidden");
        }
    })
})

/*验证密码是否简单*/
$("#regUserFirstPassword").blur(function () {
    $(".errorInfoCla span").text();
    $(".errorInfoCla").css("visibility", "hidden");
    $.get(EntryGlobalLocation + "checkInfoIsRepeat.do", {
        nickName: "",
        firstPassword: $("#regUserFirstPassword").val(),
        secondPassword: "",
        userPhone: ""
    }, function (data) {
        if (-3 == data.detectionCode) {
            $("#passFirstError").text(data.detectionMessage);
            $("#passFirstError").css("visibility", "visible");
        } else if (3 == data.detectionCode) {
            $("#passFirstError").css("visibility", "hidden");
        }
    })
})
/*验证两次密码是否相同*/
$("#regUserSecondPassword").blur(function () {
    $(".errorInfoCla span").text();
    $(".errorInfoCla").css("visibility", "hidden");
    $.get(EntryGlobalLocation + "checkInfoIsRepeat.do", {
        nickName: "",
        firstPassword: $("#regUserFirstPassword").val(),
        secondPassword: $("#regUserSecondPassword").val(),
        userPhone: ""
    }, function (data) {
        if (-4 == data.detectionCode) {
            $("#passSecondError").text(data.detectionMessage);
            $("#passSecondError").css("visibility", "visible");
        } else if (4 == data.detectionCode) {
            $("#passSecondError").css("visibility", "hidden");
        }
    })
})


/*手机号是否重复或格式是否正确*/
$("#regPhone").blur(function () {
    $(".errorInfoCla span").text();
    $(".errorInfoCla").css("visibility", "hidden");
    $.get(EntryGlobalLocation + "checkInfoIsRepeat.do", {
        nickName: "",
        firstPassword: "",
        secondPassword: "",
        userPhone: $("#regPhone").val()
    }, function (data) {
        if (-2 == data.detectionCode) {
            $("#phoneError").text(data.detectionMessage);
            $("#phoneError").css("visibility", "visible");
        } else if (2 == data.detectionCode) {
            $("#phoneError").css("visibility", "hidden");
        }
    })
})
/*序列化表单  提交注册表单数据*/
$("#regSubmit").click(function () {
    $(".errorInfoCla span").text();
    $(".errorInfoCla").css("visibility", "hidden");
    $.post(EntryGlobalLocation + "checkRegisInfo.do", $("#registerForm").serialize(), function (data) {
        if (-1 == data.detectionCode) {
            $("#nickError").text(data.detectionMessage);
            $("#nickError").css("visibility", "visible");
        } else if (-2 == data.detectionCode) {
            $("#passFirstError").text(data.detectionMessage);
            $("#passFirstError").css("visibility", "visible");
        } else if (-3 == data.detectionCode) {
            $("#phoneError").text(data.detectionMessage);
            $("#phoneError").css("visibility", "visible");
        } else if (-4 == data.detectionCode) {
            $("#phoneError").text(data.detectionMessage);
            $("#phoneError").css("visibility", "visible");
        } else if (-5 == data.detectionCode) {
            $("#regCodeError").text(data.detectionMessage);
            $("#regCodeError").css("visibility", "visible");
        } else if (0 == data.detectionCode) {
            window.location.href=CenterLocation+"testRegist.html?regSuccessAccount="+data.regSeccessUserAccount;
        }
    });
    return false;
})


/*===============================================Register===============================================*/