readme_content = """
# CalcularIMC

## Descrição

O **CalcularIMC** é um aplicativo Android desenvolvido em 2023 para o projeto da disciplina **Tecnologias para Dispositivos Mobile**. O app permite que o usuário calcule o Índice de Massa Corporal (IMC) a partir do peso e altura informados, exibindo uma avaliação do estado de saúde e um conselho baseado no resultado.

## Funcionalidades

- Cálculo do IMC com base no peso (kg) e altura (m) fornecidos pelo usuário.
- Exibição do resultado do IMC com duas casas decimais.
- Indicação visual do estado de saúde (abaixo do peso, peso normal ou acima do peso) através de imagens ilustrativas.
- Exibição de uma mensagem personalizada com recomendações de saúde baseadas no IMC.
- Confirmação de entrada dos dados com validação básica para evitar valores inválidos ou campos vazios.
- Diálogo de confirmação para logout.

## Armazenamento de Dados

Este aplicativo **não salva dados localmente** em banco de dados nem em arquivos. Contudo, o Android mantém o estado do aplicativo no dispositivo ou emulador enquanto ele não é desinstalado ou os dados do app não são limpos manualmente, o que pode dar a impressão de que os dados "ficam salvos" entre execuções.

### Para limpar os dados no emulador ou dispositivo:

- Desinstale o app.
- Limpe os dados nas configurações do app (Configurações > Apps > CalcularIMC > Limpar dados).
- Utilize comandos ADB para desinstalar o app ou limpar dados:
  - `adb uninstall com.app.calcularimc`
  - `adb shell pm clear com.app.calcularimc`

## Tecnologias Utilizadas

- Linguagem: Java
- Plataforma: Android (Android Studio)
- Componentes: `EditText`, `Button`, `ImageView`, `TextView`, `Toast`, `AlertDialog`

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/erickrmoreira/App_CalcularIMC.git
