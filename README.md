# Assembleia

Este é um projeto que visa auxiliar a criação e votação de pautas através de uma API.

## Instalação e configuração

Para instalar o sistema, é necessário que esteja instalado o docker e docker-compose, assim como o git.

- Clone o projeto
- Acesse o diretório do projeto
- Execute **docker-compose up -d** para iniciar os serviços.
- Acesse os serviços utilizando [http://localhost:8888/](http://localhost:8888/)

## Documentação da API

Este projeto é uma API REST. Abaixo estão as rotas disponíveis com exemplos de informações para os corpos das requisições, quando necessário. Assim como os retornos correspondentes.


``GET /pauta`` - Lista todas as pautas

``GET /pauta?page=PAGINA_SELECIONA`` - Lista todas as pautas cadastradas conforme a paginação


```json
Exemplo: curl -i http://localhost:8888/pauta

Retorno:
HTTP/1.1 200 
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 10 Sep 2019 01:25:06 GMT

{
  "_embedded" : {
    "pauta" : [ {
      "nome" : "Pauta 1",
      "descricao" : "Decrição da Pauta 1",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8888/pauta/1"
        },
        "pauta" : {
          "href" : "http://localhost:8888/pauta/1"
        }
      }
    }, {
      "nome" : "Pauta 2",
      "descricao" : "Decrição da Pauta 2",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8888/pauta/4"
        },
        "pauta" : {
          "href" : "http://localhost:8888/pauta/4"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8888/pauta{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8888/profile/pauta"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 2,
    "totalPages" : 1,
    "number" : 0
  }
}
```
            
``GET /pauta/{id}`` - Retorna uma pauta de acordo com o id informado
    
```json
Exemplo: curl -i http://localhost:8888/pauta/1

Retorno:
HTTP/1.1 200 
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 10 Sep 2019 01:25:59 GMT

{
  "nome" : "Pauta 1",
  "descricao" : "Decrição da Pauta 1",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8888/pauta/1"
    },
    "pauta" : {
      "href" : "http://localhost:8888/pauta/1"
    }
  }
}

```

``POST /pauta`` - Salva uma pauta

```json
Exemplo: curl -i -H "Content-Type: application/json" -X POST -d \
'{
 	"nome": "Pauta 1",
 	"descricao": "Decrição da Pauta 1"
 }' http://localhost:8888/pauta

Retorno:
HTTP/1.1 201 
Location: http://localhost:8888/pauta/1
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 10 Sep 2019 01:29:05 GMT

{
  "nome" : "Pauta 1",
  "descricao" : "Decrição da Pauta 1",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8888/pauta/1"
    },
    "pauta" : {
      "href" : "http://localhost:8888/pauta/1"
    }
  }
}
```

``PUT /pauta/{id}`` - Atualiza uma pauta

```json
Exemplo: curl -i -H "Content-Type: application/json" -X PUT -d \                                                                                                                                                [67865bd]
'{
        "nome": "Pauta 1 atualizada",
        "descricao": "Decrição da Pauta 1"
 }' http://localhost:8888/pauta/1

Retorno:
HTTP/1.1 200 
Location: http://localhost:8888/pauta/1
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 10 Sep 2019 01:37:42 GMT

{
  "nome" : "Pauta 1 atualizada",
  "descricao" : "Decrição da Pauta 1",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8888/pauta/1"
    },
    "pauta" : {
      "href" : "http://localhost:8888/pauta/1"
    }
  }
}
```
    
``DELETE /pauta/{id}`` - Remove uma pauta de acordo com o id informado

```json
Exemplo: curl -i -X DELETE http://localhost:8888/pauta/1
Retorno:
HTTP/1.1 204 
Date: Tue, 10 Sep 2019 01:39:20 GMT
```

``POST /votacao/`` - Cria uma votação para uma pauta

```json
Exemplo: curl -i -H "Content-Type: application/json" -X POST -d \
'{
 	"pauta": "http://localhost:8888/pauta/1",
 	"minutos": "2",
 	"dataCriacao": "2019-09-09T12:30:00"
 }' http://localhost:8888/votacao

Retorno:
HTTP/1.1 201 
Location: http://localhost:8888/votacao/2
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 10 Sep 2019 01:45:02 GMT

{
  "minutos" : 2,
  "dataCriacao" : "2019-09-09T12:30:00.000+0000",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8888/votacao/2"
    },
    "votacao" : {
      "href" : "http://localhost:8888/votacao/2"
    },
    "pauta" : {
      "href" : "http://localhost:8888/votacao/2/pauta"
    }
  }
}
```

Os serviços ``PUT /votacao/{id}``, ``GET /votacao/{id}``, ``GET /votacao/`` e ``DELETE /votacao/{id}`` também estão disponíveis.
Para o verbo ``PUT``, o corpo da requisição deve seguir o mesmo formato e ter os mesmo campos que o ``POST``.
   
``POST /voto/`` - Registra um voto de um associado em uma votação

```json
Exemplo: curl -i -H "Content-Type: application/json" -X POST -d \
'{
 	"votacao": "http://localhost:8888/votacao/2",
 	"voto": true,
 	"associado": "4"
 }' http://localhost:8888/voto

Retorno:
HTTP/1.1 201 
Location: http://localhost:8888/voto/3
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 10 Sep 2019 01:52:44 GMT

{
  "voto" : true,
  "associado" : 4,
  "_links" : {
    "self" : {
      "href" : "http://localhost:8888/voto/3"
    },
    "voto" : {
      "href" : "http://localhost:8888/voto/3"
    },
    "votacao" : {
      "href" : "http://localhost:8888/voto/3/votacao"
    }
  }
}
```

``GET /voto/search/votacao?votacao={votacao}`` - Consulta todos os votos de acordo com a votação informada

```json
Exemplo: curl -i http://localhost:8888/voto/search/votacao\?votacao\=http://localhost:8888/votacao/2

Retorno:
HTTP/1.1 200 
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Tue, 10 Sep 2019 01:57:57 GMT

{
  "_embedded" : {
    "voto" : [ {
      "voto" : true,
      "associado" : 4,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8888/voto/3"
        },
        "voto" : {
          "href" : "http://localhost:8888/voto/3"
        },
        "votacao" : {
          "href" : "http://localhost:8888/voto/3/votacao"
        }
      }
    }, {
      "voto" : false,
      "associado" : 5,
      "_links" : {
        "self" : {
          "href" : "http://localhost:8888/voto/5"
        },
        "voto" : {
          "href" : "http://localhost:8888/voto/5"
        },
        "votacao" : {
          "href" : "http://localhost:8888/voto/5/votacao"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8888/voto/search/votacao?votacao=http://localhost:8888/votacao/2"
    }
  }
}
```

Os serviços ``PUT /voto/{id}``, ``GET /voto/{id}``, ``GET /voto/`` e ``DELETE /voto/{id}`` também estão disponíveis.
Para o verbo ``PUT``, o corpo da requisição deve seguir o mesmo formato e ter os mesmo campos que o ``POST``.
   