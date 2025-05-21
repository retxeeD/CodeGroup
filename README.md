# Projeto de Automação de Testes com Java, Selenium, Cucumber e Gherkin

Este projeto realiza testes automatizados utilizando Java, Selenium WebDriver, Cucumber e Gherkin. Os testes seguem a estrutura Page Object Model (POM), com integração de relatórios em HTML e JSON.

---

## 🧰 Tecnologias Utilizadas

- **Java 17+**
- **Maven**
- **Selenium WebDriver**
- **Cucumber (Gherkin)**
- **JUnit**
- **Page Object Model (POM)**

---

## 📁 Estrutura do Projeto

src  
├── main  
│ └── java  
│ └── br.com.codegroup  
│ ├── pages # Page Objects  
│ │ └── HomePage.java  
│ ├── runners # Runner Cucumber  
│ │ └── TestRunner.java  
│ ├── steps # Step Definitions  
│ │ ├── HomeSteps.java  
│ │ └── Hooks.java  
│ └── utils # Utilitários  
│ └── Utils.java  
├── test  
│ └── resources  
│ ├── drivers # WebDriver executáveis  
│ │ ├── chromedriver.exe  
│ │ └── msedgedriver.exe  
│ └── features # Arquivos .feature (Gherkin)  
│ └── home.feature  
├──target/  
│ └──  cucumber-report.html  


---

## ▶️ Como Executar os Testes

### Pré-requisitos

- Java JDK 17+
- Maven 3.8+
- IDE (Ex: IntelliJ IDEA, Eclipse)
- Definir variavel de ambiente BROWSER que carrega nome do navegador que sera utilizado, nas configurações do Runner

### Passos

1. Clone o repositório: 
```bash
  git clone https://github.com/retxeeD/CodeGroup.git
```

2. Definir valor da variavel de ambiente BROWSER atraver das configurações de Run/Debug configurations com nome do navegador desejado
3. Executar os testes
