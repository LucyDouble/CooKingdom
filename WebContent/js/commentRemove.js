/**
 * 
 */
var rnoText = "";

function goCommentList(){
	var recipeCode = document.getElementById("recipeCode").value;
	console.log("recipeCode : "+ recipeCode);
	$.ajax({
		url: "commentRemove",
		type:"POST",
		data : {
			recipeCode : recipeCode,
			commentNo : rnoText
		},
		success : function(){
		commentInput.value = "";
		$.ajax({
			url:"commentListInquiry",
			type:"POST",
			dataType : "json",
			async : false,
			data: { 
				recipeCode : recipeCode
			},
			success : function(data){
				
				commentInput.value = "";
		
				var commentList = data.commentList;
				var cv = "";
				
				$("#cmt").empty();
				
				if(commentList == null || data.cnt == 0){
					cv = "<p>첫번째 댓글을 작성해 보세요!</p>";
					$("#cmt").append(cv);
				}
				
				
				if (currentMail == "null" ) {
					cv = "<p>로그인 후 확인이 가능합니다.</p>";
					$("#cmt").append(cv);
				}
				
				$("#cmt").empty();
				
				
				if(currentMail != null && currentMail != "null"){
					$.each(commentList, function(i,list){
						cv += "<div class='comment_Inq' style='display:none;'>";
						cv += "<input type='hidden' name='commentNo' value='"+commentList[i].commentNo+"' />";
						cv += "<table><tr>";
						cv += "<td class='cwriter'>"+commentList[i].nickname+"</td>";
						cv += "<td class='csub' id='csub-"+commentList[i].commentNo+"'>"+commentList[i].commentContent+"</td>";
						cv += "<td class='cdate'>"+commentList[i].commentDate+"</td>";
						cv += "</tr></table>";
						if(currentMail == commentList[i].email){
						cv += "<div class='commentBtn'>";
						cv += "<button type='button' class='cbtn' id='mbtn-"+commentList[i].commentNo+"'>수정</button>";
						cv += "<button type='button' class='cbtn' id='cbtn-"+commentList[i].commentNo+"'>삭제</button>";
						cv += "</div>";
						}
						cv += "</div>";					
					});
					
				}
				
				$("#cmt").append(cv);
					
				$("#moreDiv").empty();
				var morebtn = "<a id='moreBtn'>더보기(more)</a>";
					
				if(currentMail != null && data.cnt > 5 && currentMail != 'null'){
					$("#moreDiv").append(morebtn);				
				} 
					$(".comment_Inq").slice(0,5).show();
	
		
				$("#comment_cnt").html("<h3>댓글 ("+data.cnt+" comments)</h3>");
				
			}
		});
		},
		error : function(request, status, error){
			console.log(request);
			console.log("에러남!");
		}
		
	});
}

$(function () {
    $("body").on("click", "[id^=cbtn-]", function (e) {
		
		console.log("들어왔다");
	    var vId = this.id;
		var rno = vId.split("cbtn-")[1];
		rnoText = rno;
		console.log("rnoText : " + rnoText);
        action_popup.confirm("게시글을 삭제하시겠습니까?", function (res) {
            if (res) { 
				action_popup.alert("정상적으로 삭제되었습니다.");				
				goCommentList();
            }
        })
    });

    $(".modal_close").on("click", function (event) {
        action_popup.close(this);
		event.preventDefault();
		event.stopPropagation();
		return false;
		goCommentList();
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