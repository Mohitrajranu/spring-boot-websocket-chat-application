function doCheck(){
    var allFilled = true;
    
    var inputs = document.getElementsByTagName('input');
    for(var i=0; i<inputs.length; i++){
        if(inputs[i].type == "password" && inputs[i].value == ''){
            allFilled = false;
            break;
        }
    }
    
    document.getElementById("button").disabled = !allFilled;
}

window.onload = function(){
    var inputs = document.getElementsByTagName('input');
    for(var i=0; i<inputs.length; i++){
        if(inputs[i].type == "password"){
            inputs[i].onkeyup = doCheck;
            inputs[i].onblur = doCheck;
        }
    }
};