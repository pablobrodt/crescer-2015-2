$(function() {
  $('#btn-pesquisar').click(function(){
    $('#albuns').empty();
    var pesquisa = $('#pesquisa').val();
    $.get(verificaBusca(pesquisa))
      .done(function(data) {
        mostrarAlbuns(data.artists.items[0].id);
    })
  });


function mostrarAlbuns( id ){
  $.get('https://api.spotify.com/v1/artists/'+id+'/albums?limit=50')
    .done(function(data) {
      var itens = data.items.map(function(album){
          $('#albuns').append(
            $('<label>').text(album.name).css({'display':'block', 'font-size':'20px'}),
            $('<img>').attr('src', album.images[1].url),
            $('<br>')
          )
        });
    });
}

function verificaBusca( artista ){
  var urlNormal = 'https://api.spotify.com/v1/search?q='+artista+'&type=artist';
  var urlErrada = 'https://api.spotify.com/v1/artists/douchebag/albums?limit=50';

  return (artista === 'Justin Bieber') ? (Math.random() > 0.2) ? urlErrada : urlNormal : urlNormal;
}

});

