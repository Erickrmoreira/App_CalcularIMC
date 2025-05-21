
# App CalcularIMC

## Descrição

Este aplicativo foi criado em 2023 para o projeto da disciplina **Tecnologias para Dispositivos Mobile**. É um app bem simples, sem complexidade, que permite ao usuário calcular o Índice de Massa Corporal (IMC) e receber um status e conselho de saúde baseado no resultado.

## Funcionalidades

- **Cálculo do IMC:** O usuário insere peso e altura para calcular seu IMC.
- **Status de saúde:** Exibe uma imagem e texto que indicam se o usuário está abaixo do peso, com peso normal ou acima do peso.
- **Conselhos personalizados:** Mensagens de orientação baseadas no resultado do IMC.
- **Confirmação de logout:** Caixa de diálogo para o usuário confirmar se deseja realmente sair do app.

## Telas

O aplicativo possui 3 telas principais:

1. **Tela de Login:** Para o usuário entrar no app.
2. **Tela de Cadastro:** Para criação de nova conta.
3. **Tela Principal (Main):** Onde o cálculo do IMC é feito e os resultados são exibidos.

## Armazenamento de Dados

Este aplicativo **não salva dados localmente** em banco de dados nem em arquivos. Contudo, o Android mantém o estado do aplicativo no dispositivo ou emulador enquanto ele não é desinstalado ou os dados do app não são limpos manualmente, o que pode dar a impressão de que os dados "ficam salvos" entre execuções.

### Para limpar os dados no emulador ou dispositivo:

- Desinstale o app.
- Limpe os dados nas configurações do app (Configurações > Apps > CalcularIMC > Limpar dados).

## Tecnologias Utilizadas

- Linguagem: Java
- Plataforma: Android (Android Studio)
- Componentes: `EditText`, `Button`, `ImageView`, `TextView`, `Toast`, `AlertDialog`

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/erickrmoreira/App_CalcularIMC.git
