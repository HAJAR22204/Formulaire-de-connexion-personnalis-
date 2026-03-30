# SecureApp - Authentification personnalisée avec Spring Security

## Description du projet

**SecureApp** est une application web développée avec **Spring Boot**, **Spring Security** et **Thymeleaf**, ayant pour objectif de mettre en œuvre un **système d’authentification sécurisé avec interface personnalisée**.

Ce projet a été réalisé dans le cadre d’un **travail pratique (TP)** portant sur la compréhension et la personnalisation du mécanisme d’authentification de **Spring Security**.

L’application remplace la page de connexion par défaut de Spring Security par une **page de connexion HTML personnalisée**, tout en assurant :

- la gestion de l’authentification,
- la redirection après connexion,
- la gestion des erreurs de connexion,
- la déconnexion,
- et la restriction d’accès selon les rôles.

---

## Objectifs pédagogiques

Ce projet permet de comprendre et de pratiquer les concepts suivants :

- le fonctionnement du **flux d’authentification** dans Spring Security,
- la configuration d’un **formulaire de connexion personnalisé**,
- la gestion des **accès sécurisés par rôles**,
- la redirection après **connexion ou déconnexion**,
- et l’intégration de **Thymeleaf** avec Spring Boot.

---

## Fonctionnalités principales

L’application propose les fonctionnalités suivantes :

- **Page de connexion personnalisée**
- **Authentification sécurisée**
- **Gestion des erreurs de connexion**
- **Déconnexion sécurisée**
- **Page d’accueil après authentification**
- **Affichage de l’utilisateur connecté**
- **Accès différencié selon les rôles**
- **Interface simple et moderne**

---

## Technologies utilisées

- **Java**
- **Spring Boot**
- **Spring Security**
- **Spring MVC**
- **Thymeleaf**
- **HTML / CSS**
- **Maven**

---

## Structure du projet

```bash
src
 ├─ main
 │   ├─ java
 │   │   └─ ma/fstg/security
 │   │       ├─ config
 │   │       │   └─ SecurityConfig.java
 │   │       └─ web
 │   │           └─ AuthController.java
 │   └─ resources
 │       ├─ templates
 │       │   ├─ connexion.html
 │       │   ├─ accueil.html
 │       │   ├─ admin-dashboard.html
 │       │   └─ user-dashboard.html
 │       └─ application.properties
```

## Flux d’authentification

Le fonctionnement général de l’application est le suivant :

L’utilisateur tente d’accéder à une ressource protégée.
Spring Security intercepte la requête.
Si l’utilisateur n’est pas authentifié, il est redirigé vers la page de connexion.
Le formulaire envoie les identifiants au serveur.
Spring Security vérifie les informations de connexion.
En cas de succès :
l’utilisateur est authentifié,
puis redirigé vers la page d’accueil.
En cas d’échec :
l’utilisateur est redirigé vers la page de connexion avec un message d’erreur.
Lors de la déconnexion :
la session est invalidée,
puis l’utilisateur est redirigé vers la page de connexion.
Gestion des rôles

L’application met en place une gestion simple des rôles :

USER : accès à l’espace personnel
ADMIN : accès à l’espace personnel et au panneau de gestion
Restrictions d’accès
/connexion : accessible à tous
/accueil : accessible uniquement après authentification
/user/** : accessible aux utilisateurs authentifiés
/admin/** : accessible uniquement aux administrateurs
Comptes de test

L’application utilise une authentification en mémoire avec deux utilisateurs de test.

Exemple :
Utilisateur standard
Identifiant : user
Mot de passe : 1111
Administrateur
Identifiant : admin
Mot de passe : 1234

Remarque : les identifiants peuvent varier selon la configuration définie dans SecurityConfig.java.

## Interface utilisateur

L’interface de l’application a été personnalisée afin d’améliorer :

l’ergonomie,
la lisibilité,
l’expérience utilisateur,
et l’aspect visuel général.

Les principales pages sont :

Page de connexion
Page d’accueil
Espace utilisateur
Panneau administrateur
Lancement du projet
Prérequis

Avant d’exécuter l’application, assurez-vous d’avoir installé :

Java 17 (ou version compatible)
Maven
IDE recommandé : IntelliJ IDEA / VS Code / Eclipse
Étapes d’exécution
Cloner ou télécharger le projet
Ouvrir le projet dans votre IDE
Lancer l’application avec la commande suivante :
mvn spring-boot:run
Ouvrir votre navigateur et accéder à :
http://localhost:8080/connexion
Résultats attendus
Cas de test
Accès à une ressource protégée sans connexion
→ redirection vers la page de connexion
Connexion réussie
→ redirection vers la page d’accueil
Mauvais identifiants
→ affichage d’un message d’erreur
Déconnexion
→ retour à la page de connexion
Accès non autorisé à une page admin
→ refus d’accès
Apports du projet

Ce projet m’a permis de mieux comprendre :

la configuration de Spring Security,
le rôle de SecurityFilterChain,
l’utilisation de UserDetailsService,
le principe de sécurisation des routes,
et la personnalisation d’une interface d’authentification.

Il constitue une première étape vers des systèmes plus avancés, tels que :

l’authentification via base de données,
l’inscription utilisateur,
la gestion avancée des rôles et permissions,
ou encore l’intégration avec JWT.
Conclusion

SecureApp est une application simple mais pédagogique qui illustre le fonctionnement de Spring Security à travers un cas pratique concret.

Ce projet met en évidence l’importance de :

sécuriser les accès,
personnaliser l’expérience utilisateur,
et organiser les rôles selon les droits d’accès.
