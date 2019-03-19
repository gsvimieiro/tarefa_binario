# Tarefa Binário

Projeto implementado para atender a primeira tarefa do processo seletivo da CAST

# Objetivo

Fornecer 2 endpoints http que aceitam dados binários codificados em base64 JSON em ambos os endpoints

. <host>/v1/diff/<ID>/left 
. <host>/v1/diff/<ID>/right
  
Executar um terceiro endpoint final

. /v1/diff/ 

Obter os seguintes resultados :

Caso arquivos iguais retornar TRUE

Caso arquivos diferentes e tamanhos diferentes retornar Tamanho

Caso arquivos com tamanhos iguais, comparar byte a byte e retornar aonde estão as diferenças 


# Tecnologia Utilizada

Java Spring Boot
Maven

# Teste Unitário e teste de Integração

Não implementados

# Modo de testar

Sugestão através do Postman rodar duas requisições REST via POST

/v1/diff/{id}/right com o arquivo enviado no corpo da requisição
e
/v1/diff/{id}/left com o arquivo enviado no corpo da requisição

Por fim rodar uma requisição REST via GET

/v1/diff/{id}/diff  

