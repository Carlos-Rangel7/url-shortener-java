# Encurtador de URL

Você pode acessar o projeto completo na web em: [https://www.rangeldev.com/](https://www.rangeldev.com)

Este projeto implementa um encurtador de URL simples, permitindo que os usuários insiram uma URL longa e obtenham uma versão encurtada. O projeto é dividido em duas partes: o back-end, que é feito com **Java** e **Spring**, e o front-end, que utiliza **HTML**, **CSS** e **JavaScript** para interações e mensagens.

## Funcionalidades

- **Encurtar uma URL**: O usuário pode inserir uma URL longa e obter uma versão encurtada.
- **Verificação de URL já encurtada**: Caso a URL já tenha sido encurtada anteriormente, o sistema retornará a versão já existente, evitando duplicações.
- **Copiar a URL encurtada** para a área de transferência.
- **Exibição de mensagens de erro e sucesso** para o usuário.
- **Limpar os campos de entrada**: Permite que o usuário limpe a URL inserida para tentar novamente.
- **Clicar na URL encurtada** leva diretamente o usuário para a página original, tornando a experiência ainda mais conveniente.

## Tecnologias Usadas

### Back-End:
- **Java**: A linguagem de programação utilizada.
- **Spring Boot**: Framework para criação da API REST que processa o encurtamento de URL.

### Front-End:
- **HTML5**: Para estruturar a página.
- **CSS3**: Para o estilo da página.
- **JavaScript**: Para a funcionalidade de encurtamento e interação com a API, além de exibição de mensagens de erro e sucesso.

## Como Funciona

1. O usuário insere uma URL longa no campo de entrada.
2. Ao clicar no botão de encurtar, o sistema verifica se a URL já foi encurtada anteriormente.
   - **Caso a URL já tenha sido encurtada**, o sistema retorna a versão encurtada existente.
   - **Se for uma URL nova**, o sistema gera uma versão encurtada e a exibe para o usuário.
3. O usuário pode clicar na URL encurtada para ser redirecionado diretamente para o link original.
4. O usuário também pode copiar a URL encurtada clicando no botão de copiar.
5. Caso o usuário deseje, pode limpar o campo de entrada para tentar com outra URL.

## Imagens

Imagem do layout da aplicação:

![image](https://github.com/user-attachments/assets/fdaf6a23-03d9-4850-8571-2d8bb6339d4c)

Após encurtar uma URL, aparecem opções para limpar o campo ou copiar a URL encurtada:

![image](https://github.com/user-attachments/assets/93443498-8889-40c5-80b8-50bcd6f663e8)


