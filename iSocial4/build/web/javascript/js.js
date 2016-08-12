$(document).ready(function() {
    $("#filtroTipos").change(function() {
        var seleccion = $("#filtroTipos").val();
        
        if(seleccion == "0") {
            $("#top5").slideDown("slow");
            $("#topComida").slideUp("slow");
            $("#topBebida").slideUp("slow");
            $("#topEntretenimiento").slideUp("slow");
        }
        if(seleccion == "1") {
            $("#topComida").slideDown("slow");
            $("#top5").slideUp("slow");
            $("#topBebida").slideUp("slow");
            $("#topEntretenimiento").slideUp("slow");
        }
        if(seleccion == "2") {
            $("#topBebida").slideDown("slow");
            $("#topComida").slideUp("slow");
            $("#top5").slideUp("slow");
            $("#topEntretenimiento").slideUp("slow");
        }
        if(seleccion == "3") {
            $("#topEntretenimiento").slideDown("slow");
            $("#topComida").slideUp("slow");
            $("#topBebida").slideUp("slow");
            $("#top5").slideUp("slow");
        }
    });
    
    $("#mostrarGeneral").click(function() {
        $("#top5").toggle("slow");
    });
    
    $("#mostrarComidas").click(function() {
        $("#topComida").toggle("slow");
    });
    
    $("#mostrarBebidas").click(function() {
        $("#topBebida").toggle("slow");
    });
    
    $("#mostrarEntretenimiento").click(function() {
        $("#topEntretenimiento").toggle("slow");
    });
});