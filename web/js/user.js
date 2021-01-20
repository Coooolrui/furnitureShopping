$(function () {
    $(".edit").click(function () {
        // alert(123465)
        $.get(
            "address?opt=queryArea",
            {
                'code':'000000'
            },
            function (data){
                $("#pro")[0].innerHTML = '<option value="省份/自治区">省份/自治区</option>'
                $("#city")[0].innerHTML = '<option value="城市/地区">城市/地区</option>'
                $("#qu")[0].innerHTML = '<option value="区/县">区/县</option>'
                $("#area")[0].innerHTML = '<option value="配送区域">配送区域</option>'
                let areas = JSON.parse(data);
                for (let i in areas){
                    $('#pro').append('<option value='+areas[i].id+'-'+areas[i].code+'>'+areas[i].name+'</option>')
                }
            }
        )
        // console.log($(this).attr('ids'))
        let ids = $(this).attr('ids')
        $("#save").attr('ids', ids)

        $.get(
            "address?opt=queryAddress",
            {
                'aid':ids
            },
            function (data){
                // console.log(data)
                jsondata = JSON.parse(data)
                $("#name").val(jsondata.userName)
                $("#phone").val(jsondata.userPhone)
                $("#xaddr").val(jsondata.userAddress)
                $("#postcode").val(jsondata.postcode)
                // $("#pro").val(jsondata.)
                // $("#pro").find('option[value='+jsondata.province.id+'-'+jsondata.province.code+']').attr("selected", true);
            }
        )
        // console.log("============")
        // console.log(jsondata)
        // $.get(
        //     "/order?opt=queryArea",
        //     {
        //         'code':$("#pro").val().split("-")[1]
        //     },
        //     function (data){
        //         $("#city")[0].innerHTML = '<option value="城市/地区">城市/地区</option>'
        //         $("#qu")[0].innerHTML = '<option value="区/县">区/县</option>'
        //         $("#area")[0].innerHTML = '<option value="配送区域">配送区域</option>'
        //         let areas = JSON.parse(data);
        //         for (let i in areas){
        //             $('#city').append('<option value='+areas[i].id+'-'+areas[i].code+'>'+areas[i].name+'</option>')
        //         }
        //     }
        // )
        // $("#city").find('option[value='+jsondata.city.id+'-'+jsondata.city.code+']').attr("selected", true)
        // $("#qu").find('option[value='+jsondata.area.id+'-'+jsondata.area.code+']').attr("selected", true)
        // $("#area").find('option[value='+jsondata.street.id+'-'+jsondata.street.code+']').attr("selected", true)

        $(".mask").show();
        $(".adddz").show()
    });
    $(".bc>input").click(function () {

        if ($(this).val() == "保存") {
            // alert($("#save").attr('add'))
            if ($("#add").val() == ""){
                // alert(123465)
                if ($("#name").val() != '' && $("#phone").val() != '' && $("#pro").val() != '省份/自治区' && $("#city").val() != '城市/地区'
                    && $('#qu').val() != '区/县' && $('#area').val() != '配送区域' && $("#xaddr").val() != '' && $('#postcode').val() != ''){
                    $.post(
                        'address?opt=update',
                        {
                            "name":$("#name").val(),
                            "phone":$("#phone").val(),
                            "pro":$("#pro").val().split('-')[0],
                            "city":$("#city").val().split('-')[0],
                            "area":$('#qu').val().split('-')[0],
                            "street":$('#area').val().split('-')[0],
                            "xaddr":$("#xaddr").val(),
                            "postcode":$('#postcode').val(),
                            "aid":$("#save").attr('ids')
                        },
                        function (data){
                            if (data == '1'){
                                alert("保存成功")
                                $(".mask").hide();
                                $(".adddz").hide();
                                $(".bj").hide();
                                $(".xg").hide();
                                $(".remima").hide();
                                $(".pj").hide();
                                $(".chak").hide()
                                window.location.href = 'order?opt=show'
                            }else if (data == '0') {
                                alert("保存失败")
                            }
                        }
                    )
                }else {
                    alert("请输入合法信息！！")
                }
            }else {
                // alert(456789)
                if ($("#name").val() != '' && $("#phone").val() != '' && $("#pro").val() != '省份/自治区' && $("#city").val() != '城市/地区'
                    && $('#qu').val() != '区/县' && $('#area').val() != '配送区域' && $("#xaddr").val() != '' && $('#postcode').val() != ''){
                    $.post(
                        'address?opt=add',
                        {
                            "name":$("#name").val(),
                            "phone":$("#phone").val(),
                            "pro":$("#pro").val().split('-')[0],
                            "city":$("#city").val().split('-')[0],
                            "area":$('#qu').val().split('-')[0],
                            "street":$('#area').val().split('-')[0],
                            "xaddr":$("#xaddr").val(),
                            "postcode":$('#postcode').val()
                        },
                        function (data){
                            if (data == '1'){
                                alert("保存成功")
                                $(".mask").hide();
                                $(".adddz").hide();
                                $(".bj").hide();
                                $(".xg").hide();
                                $(".remima").hide();
                                $(".pj").hide();
                                $(".chak").hide()
                                $("#add").val("")
                                // window.location.href = 'order?opt=show'
                                location.reload()
                            }else if (data == '0') {
                                alert("保存失败")
                            }
                        }
                    )
                }else {
                    alert("请输入合法信息！！")
                }
            }

        } else {
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide()
            $("#add").val("")
        }
    });
    $("#wa li").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
        var a = $(this).find("a").text();
        $(".dkuang").find("p.one").each(function () {
            var b = $(this).text();
            if (a == b) {
                $(this).parent(".dkuang").show().siblings(".dkuang").hide()
            }
            $("#wa li").eq(0).click(function () {
                $(".dkuang").show()
            })
        })
    });
    $(".sx div:gt(0)").hide();
    $(".sx div").each(function (a) {
        if ($(this).html() == "") {
            var b = $("#pro li").eq(a).find("a").text();
            var c = "";
            c = '<div class="noz">当前没有' + b + "。</div>";
            $(this).html(c)
        }
    });
    $("#pro li").click(function () {
        $(this).addClass("on").siblings().removeClass("on");
        var a = $(this).index();
        $(".sx > div").eq(a).show().siblings().hide()
    });
    $(".sx dl dd").find("a").click(function () {
        if ($(this).text() == "评价") {
            $(".mask").show();
            $(".pj").show()
        } else {
            if ($(this).text() == "查看评价") {
                $(".mask").show();
                $(".chak").show()
            } else {
                $(".mask").hide();
                $(".pj").hide();
                $(".chak").hide()
            }
        }
    });
    $("#xin").each(function (a) {
        $("#xin").eq(a).children("a").click(function () {
            var b = $(this).index();
            for (var c = 0; c < 5; c++) {
                if (c <= b) {
                    $("#xin").eq(a).find("a").eq(c).find("img").attr("src", "img/hxin.png")
                } else {
                    $("#xin").eq(a).find("a").eq(c).find("img").attr("src", "img/xin.png")
                }
            }
        })
    });
    $("#edit1").click(function () {
        $(".mask").show();
        $(".bj").show()
    });
    $("#edit2").click(function () {
        $(".mask").show();
        $(".xg").show()
    });
    $("#avatar").click(function () {
        $(".mask").show();
        $(".avatar").show()
    });
    $(".gb").click(function () {
        $(".mask").hide();
        $(".bj").hide();
        $(".xg").hide();
        $(".remima").hide();
        $(".avatar").hide();
        $(".pj").hide();
        $(".chak").hide()
    });
    $("#addxad").click(function () {
        $(".mask").show();
        $(".adddz").show()
    });
    $(".dizhi").hover(function () {
        var a = "";
        a = '<p class="addp"><a href="#"  id="readd">修改</a><a href="#" id="deladd">删除</a></p>';
        $(this).append(a);
        $("#readd").click(function () {
            $(".mask").show();
            $(".readd").show()
        });
        $("#deladd").click(function () {
            $(this).parents(".dizhi").remove()
        })
    }, function () {
        $(".bc>input").click(function () {
            if ($(this).val() == "保存") {
                $(".mask").hide();
                $(".readd").hide()
            } else {
                $(".mask").hide();
                $(".readd").hide()
            }
        });
        $(".addp").remove()
    });
    $(".vewwl").hover(function () {
        $(this).children(".wuliu").fadeIn(100)
    }, function () {
        $(this).children(".wuliu").fadeOut(100)
    })
});