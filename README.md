readme_content = """# App CalcularIMC

Aplicativo Android para cálculo do Índice de Massa Corporal (IMC) com interface simples e amigável. O app calcula o IMC baseado nos dados de peso e altura fornecidos pelo usuário, exibindo o resultado, um status de saúde com imagem ilustrativa, além de um conselho personalizado.

---

## Funcionalidades

- **Entrada de dados:** O usuário insere seu peso (em kg) e altura (em metros) por meio de campos de texto.
- **Validação:** O app valida os dados para garantir que os campos não estejam vazios e que os valores sejam positivos e numéricos.
- **Cálculo do IMC:** O IMC é calculado usando a fórmula:  
  `IMC = peso / (altura * altura)`
- **Exibição do resultado:** Mostra o valor do IMC com duas casas decimais.
- **Status de saúde:** Exibe um texto descritivo e uma imagem correspondente ao estado:  
  - Abaixo do peso (IMC < 18.5)  
  - Peso normal (IMC >= 18.5 e < 25)  
  - Acima do peso (IMC >= 25)
- **Conselhos personalizados:** Mensagens específicas baseadas na faixa de IMC do usuário.
- **Confirmação de logout:** Diálogo para confirmar se o usuário realmente deseja sair do app.

---

## Armazenamento dos dados

Este aplicativo **não armazena dados localmente nem remotamente**. Todos os cálculos são realizados em tempo real a partir dos dados inseridos no momento pelo usuário. Após o fechamento do app, os dados são descartados.  

Se desejar, pode-se estender o app para salvar históricos usando banco de dados local (ex: SQLite) ou armazenamento em nuvem.

---

## Requisitos do sistema

- Android Studio 4.0 ou superior
- SDK Android 21 (Lollipop) ou superior
- Dispositivo ou emulador com Android

---

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/erickrmoreira/App_CalcularIMC.git
