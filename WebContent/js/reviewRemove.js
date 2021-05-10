/**
 * 
 */
var rnoText = "";
$("body").on("click", "[id^=rsub-]", function(event) {    
    var vId = this.id;
	var v = document.getElementById(vId);
	var rno = v.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling;
	rnoText = $(rno).text();
});

function goList(){
	console.log("rnoText : " + rnoText);
	var recipeCode = document.getElementById("recipeCode").value;
	console.log("recipeCode : "+ recipeCode);
	$.ajax({
		url: "reviewRemove",
		type:"POST",
		data : {
			recipeCode : recipeCode,
			reviewNo : rnoText
		},
		success : function(data){
			console.log("성공!");
			window.location = "reviewListInquiry";
		},
		error : function(request, status, error){
			console.log(request);
			console.log("에러남!");
		}
	});
}

$(function () {
    $(document).on("click", "[id^=delete_modal-]", function () {
        action_popup.confirm("게시글을 삭제하시겠습니까?", function (res) {
            if (res) { 
				action_popup.alert("정상적으로 삭제되었습니다.");				
				goList();
            }
        })
    });

    $(".modal_close").on("click", function () {
        action_popup.close(this);
    });
});



/**
 *  alert, confirm 대용 팝업 메소드 정의 <br/>
 *  timer : 애니메이션 동작 속도 <br/>
 *  alert : 경고창 <br/>
 *  confirm : 확인창 <br/>
 *  open : 팝업 열기 <br/>
 *  close : 팝업 닫기 <br/>
 */ 
var action_popup = {
    timer: 500,
    confirm: function (txt, callback) {
        if (txt == null || txt.trim() == "") {
            console.warn("confirm message is empty.");
            return;
        } else if (callback == null || typeof callback != 'function') {
            console.warn("callback is null or not function.");
            return;
        } else {
            $(".type-confirm .btn_ok").on("click", function () {
                $(this).unbind("click");
                callback(true);
                action_popup.close(this);
            });
            this.open("type-confirm", txt);
        }
    },

    alert: function (txt) {
        if (txt == null || txt.trim() == "") {
            console.warn("confirm message is empty.");
            return;
        } else {
            this.open("type-alert", txt);
        }
    },

    open: function (type, txt) {
        var popup = $("." + type);
        popup.find(".menu_msg").text(txt);
        $("body").append("<div class='dimLayer'></div>");
        $(".dimLayer").css('height', $(document).height()).attr("target", type);
        popup.fadeIn(this.timer);
    },

    close: function (target) {
        var modal = $(target).closest(".modal-section");
        var dimLayer;
        if (modal.hasClass("type-confirm")) {
            dimLayer = $(".dimLayer[target=type-confirm]");
        } else if (modal.hasClass("type-alert")) {
            dimLayer = $(".dimLayer[target=type-alert]")
        } else {
            console.warn("close unknown target.")
            return;
        }
        modal.fadeOut(this.timer);
        setTimeout(function () {
            dimLayer != null ? dimLayer.remove() : "";
        }, this.timer);
    }
}