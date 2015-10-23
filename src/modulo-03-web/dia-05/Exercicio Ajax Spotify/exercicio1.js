$(function() {
        $.get('https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50')
          .done(function(data) {
            var itens = data.items.map(function(album){
                $('section').append(
                  $('<label>').text(album.name).css({'display':'block', 'font-size':'20px'}),
                  $('<img>').attr('src', album.images[1].url),
                  $('<br>'),$('<br>'),$('<br>'),$('<hue>'),$('<hue>'),$('<hue>')
                );
            });

            console.log(itens);
          });
        });