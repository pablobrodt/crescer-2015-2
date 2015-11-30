$(document).ready(function(){
	
	function obterListaMateriais(){
		var id = $("#comboServico option:selected").attr("value");
		$.ajax({
		    url: '/Produtos/rest/'+id,
		    type: 'GET',
		    dataType: "json",
		    success: function(data){ 
		    	$("#comboMaterial").empty();
		    	
		    	var option = $('<option></option>').attr("value", 0)
				.text('Selecione um Material');
		    	
		    	$("#comboMaterial").append(option);
		    	
		    	for(var i = 0; i < data.length; i++){
		    		var option = $('<option></option>').attr("value", data[i].material.id)
		    											.text(data[i].material.descricao);
		    		$("#comboMaterial").append(option);
		    	}
		    }
		});
	}
	
	function obterIdPedido(){
		var idServico = $("#comboServico option:selected").attr("value");
		var idMaterial = $("#comboMaterial option:selected").attr("value");
		
		if(idServico != 0 && idMaterial != 0){
			$.ajax({
			    url: '/Produtos/rest/'+idServico+'/'+idMaterial,
			    type: 'GET',
			    dataType: "json",
			    success: function(data){ 
			    	$("#produto").val(data.idProduto);
			    }
			});
		}else{
			$("#produto").val(0);
		}
	}
	
	$("#comboServico").change(function(){
		obterListaMateriais();
		obterIdPedido();
	});
	
	$("#comboMaterial").change(function(){
		obterIdPedido();
	});
	
});

