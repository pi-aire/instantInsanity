# Instant Insanity

Nous avons conçu deux modèles différents pour résoudre des instances du problème d'Instant Insanity.

Le premier modèle est défini dans la classe [Resolver.java](./instantInsanity/src/main/java/instantInsanity/Resolver.java) qui utilise des contraintes spécifiques [InsanityPropagator.java](./instantInsanity/src/main/java/instantInsanity/InsanityPropagator.java).

Le second modèle est défini dans la classe [New_Resolver.java](./instantInsanity/src/main/java/instantInsanity/New_Resolver.java). Ce modèle utilise la conception d'expressions et les contraintes fournies par Choco-Solver.

# Getting started 

Notre projet utilise Maven, il suffit donc de cloner ou télécharger le dépôt puis de l'ouvrir dans votre IDE. Avec Visual Studio Code et le Java Extension pack, aucune commande supplémentaire n'est nécessaire. </br>
Si vous souhaitez executer le benchmark que nous avons utilisé pour réaliser nos calculs, il vous suffit d'utiliser la commande </br>
`mvn -Dtest=BenchmarkTest test` </br>
dans le dossier contenant le fichier *pom.xml*
