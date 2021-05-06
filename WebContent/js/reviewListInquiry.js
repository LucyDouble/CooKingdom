/**
 * 
 */

document.getElementById("rsubjs").onclick = function(){
    
    if(document.getElementById("review_content").style.display != "block"){
        document.getElementById("review_content").style.display = "block";
    }else{
        document.getElementById("review_content").style.display = "none";
    }
}
var currentTab = document.getElementById("review");
currentTab.style.display="block";

function openCont(evt, cont) {
    // Declare all variables
    var i, tabcontent, tablinks;
    
    

    var currentTab = document.getElementById("review");
    currentTab.style.display="block";
    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab  
    document.getElementById(cont).style.display = "block";
    evt.currentTarget.className += " active";
  }

  