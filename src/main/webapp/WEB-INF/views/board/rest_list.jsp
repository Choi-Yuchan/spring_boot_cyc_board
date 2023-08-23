<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
  	function getList(){
  		$.ajax({
  			type: "GET",
  			url: "/boards/list",
  			success: function(result){
  				console.log(result);
  				
  			  var htmls="";
              
              $("#list-table").html("");   

            $("<tr>" , {
               html : "<td>" + "번호" + "</td>"+  // 컬럼명들
                     "<td>" + "이름" + "</td>"+
                     "<td>" + "제목" + "</td>"+
                     "<td>" + "날짜" + "</td>"+            
                     "<td>" + "히트" + "</td>"+
                     "<td>" + "삭제" + "</td>"
            }).appendTo("#list-table") // 이것을 테이블에붙임

            if(result.length < 1){
               htmls.push("등록된 댓글이 없습니다.");
            } else {

                       $(result).each(function(){                                                          
                          htmls += '<tr>';
                          htmls += '<td>'+ this.bid + '</td>';
                          htmls += '<td>'+ this.bname + '</td>';
                          htmls += '<td>'
                        for(var i=0; i < this.bindent; i++) { //for 문은 시작하는 숫자와 종료되는 숫자를 적고 증가되는 값을 적어요. i++ 은 1씩 증가 i+2 는 2씩 증가^^
                           htmls += '-'   
                       }
                          htmls += '<a href="${pageContext.request.contextPath}/content_view?bid=' + this.bid + '">' + this.btitle + '</a></td>';
                           htmls += '<td>'+ this.bdate + '</td>'; 
                          htmls += '<td>'+ this.bhit + '</td>';   
                          htmls+='<td>'+ "<input type='button' class='del-button' id=" + this.bid + ' value="삭제" />' +  '</td>';      
                          htmls += '</tr>';                                                      
                      });   //each end

                      htmls+='<tr>';
                      htmls+='<td colspan="5"> <a href="${pageContext.request.contextPath}/write_view">글작성</a> </td>';                         
                      htmls+='</tr>';
           
                      
            }

            $("#list-table").append(htmls);
  			},
  			error: function(e){
  				console.error(e);
  			}
  			
  		});		
  	}
  </script>

<script type="text/javascript">
   	$(document).ready(function(){
   		getList();
   	});
   </script>

<script>
   //삭제
     $(document).on("click",".del-button",function(){
      console.log(this);
      var obj = $(this);
      
      $.ajax({
    	type:'DELETE',
    	url:"/boards/" + $(this).attr("id"),
    	success: function(result){
    		$(obj).parent().parent().remove();
    		console.log(result);
    	},
    	error: function(e){
    		console.error(e);
    	}
      });   
    });
</script>
</head>
<body>
	<table id="list-table" width="500" border="1"></table>
</body>
</html>