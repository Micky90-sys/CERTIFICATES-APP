# CERTIFICATES-APP

## Descrizione
CERTIFICATES-APP è un'applicazione backend Java che gestisce l'invio di certificati. Utilizza Spring Boot, Hibernate, MySQL e ActiveMQ per fornire un'API REST per le operazioni CRUD su certificati e per l'invio di email con o senza allegati. 

## Struttura del Progetto
- **Controller**: Gestisce le richieste HTTP.
- **Service**: Contiene la logica di business.
- **Repository**: Gestisce l'accesso ai dati.
- **Model**: Definisce le entità di dominio.

## Tecnologie Utilizzate
- Java
- Spring Boot
- Hibernate
- MySQL
- ActiveMQ
- Maven
- GitHub Actions (CI/CD)

## Prerequisiti
- Java 17
- Maven
- MySQL
- ActiveMQ

## Installazione
1. Clona il repository:
    ```bash
    git clone https://github.com/Micky90-sys/CERTIFICATES-APP.git
    cd CERTIFICATES-APP
    ```

2. Configura il database MySQL:
    ```sql
    CREATE DATABASE certificates_app;
    ```

3. Modifica `src/main/resources/application.properties` con le credenziali del tuo database MySQL.

4. Avvia ActiveMQ.

5. Compila e avvia l'applicazione:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Utilizzo
L'applicazione espone una serie di endpoint REST per la gestione dei certificati. Alcuni esempi:

- **GET** `/api/certificates`: Recupera tutti i certificati.
- **POST** `/api/certificates`: Crea un nuovo certificato.
- **PUT** `/api/certificates/{id}`: Aggiorna un certificato esistente.
- **DELETE** `/api/certificates/{id}`: Elimina un certificato.

## Integrazione Continua
Il progetto utilizza GitHub Actions per la CI/CD. Ogni push attiva il workflow definito in `.github/workflows/ci.yml` che esegue il build e i test.

## Contribuzione
1. Forka il repository.
2. Crea un nuovo branch (`git checkout -b feature/nuova-feature`).
3. Fai il commit delle tue modifiche (`git commit -am 'Aggiunge nuova feature'`).
4. Push del branch (`git push origin feature/nuova-feature`).
5. Apri una Pull Request.

## Licenza
Questo progetto è distribuito sotto la licenza MIT. Vedi il file [LICENSE](LICENSE) per ulteriori dettagli.
