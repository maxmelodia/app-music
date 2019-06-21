# app-music!

API que gerencia **playlists**, **músicas** e **artistas**.  Ela é a porta de entrada para a comunicação com os serviços do Spotify e do Musixmatch.

Para se utilizar a API, siga os seguintes passos:

-  Para acessar a API o usuário deverá autenticar-se com uma conta do Spotify.

- As músicas/artistas localizados, poderão ser inseridos no app-music e em seguida     adicionadas a uma playlist.

- Quando o usuário quiser ver uma letra de música, automaticamente o app-lyrics será
requisitado e a música.

- A nota da Playlist poderá ser dada ao gravar ou atualizar uma playlist.


Parte do modelo arquitetural da API representada abaixo:

![enter image description here](https://lh3.googleusercontent.com/5s-WdBk2E7v71mgU8ny0s0nusZWkQl_abcVvQ8G-iZxmSCXY68QSJA0_DNRQUqIzQoQO4R06d3Lx "app-music-modelo")
A documentação do microsserviço foi documentada pelo Swagger. Visualização através da seguinte URL:

- http://[host]/swagger-ui.html

- Implementado o padrão "Circuit Breaker", utilizando o Hystrix, biblioteca desenvolvida pela NetFlix para evitar problemas de latência e falhas no microsserviço.
