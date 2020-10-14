# Instant Insanity

Nous avons conçu deux modèles différent pour résoudre des instances du problème d'instant insanity.

Le premier modèle est définis dans la classe [Resolver.java](./instantInsanity/src/main/java/instantInsanity/Resolver.java) qui utilise des contraintes spécifiques [InsanityPropagator.java](./instantInsanity/src/main/java/instantInsanity/InsanityPropagator.java).

Le second modèle est définis dans la classe [Resolver_old.java](./instantInsanity/src/main/java/instantInsanity/Resolver_old.java). Ce modèle utilise la conception d'expression et les contraintes fournies par choco-solver.

## Problèmes rencontrés actuellement
Avec le premier modèle, le solver ne fournie pas de solution du à notre propagator. Mais on n'a pas d'explication qui nous permet de résoudre le problème.

Avec le second modèle, on a un seul passage dans les contraintes. Si les variable ne respect pas les contraintes choco retourne comme quoi il n'y a pas de solution.