# hateos
 Nivel de maturidades do REST - Hypermedia

HATEOAS é uma restrição que faz parte da arquitetura de aplicações REST, cujo objetivo é ajudar os clientes a consumirem o serviço sem a necessidade de conhecimento prévio profundo da API.

O acrônimo HATEOAS vem de Hypermedia As the Engine Of Application State e o termo “hypermedia” no seu nome já dá uma ideia de como este componente funciona em uma aplicação RESTful. Ao ser implementado, a API passa a fornecer links que indicarão aos clientes como navegar através dos seus recursos.

Com isso, o cliente não precisa ter um conhecimento profundo da API, basta conhecer a URL de inicial e partir dos links fornecidos poderá acessar todos os recursos de forma circular, se guiando através das requisições realizadas.

De acordo com o modelo de maturidade de Richardson, o HATEOAS é considerado o último nível de uma API RESTful. Desta forma, caso esteja procurando definir uma API que siga o padrão RESTful, o HATEOAS deve ser implementado nela.

Mas mesmo que não esteja seguindo o padrão RESTful a risca, é fato que o componente HATEOAS facilita e muito a manutenção de uma API e a sua integração com outras aplicações. Então, sempre que possível procure implementá-la nas APIs que desenvolver.

Neste projecto criar duas entidades diferentes... Soldados e customer.

Implementei de modo diferente aonde no controler define a logica dos links e na outra na classe service.