# JUEGO DE LETRAS

## INTRODUCCIÓN. JUEGO DE LETRAS.

*Los **nombres** de los atributos, clases, constantes, etc. deben seguir el **estándar**
de nomenclatura.
Todos los **atributos** deben ser **privados**.
Las **constantes y variables estáticas** deben ser **públicas**.
Todas las **clases** y **métodos** deben ser **públicos**, salvo que se diga lo contrario.
Las notas de los apartadas son aproximadas y sin ponderar a 10. Son una
referencia de la importancia de cada apartado.*

Se desea hacer un programa para gestionar el programa de “Letras”, *no para
resolverlo*, sólo para la generación aleatoria de las letras, además de para comprobar
que las respuestas de los concursantes son “correctas” (con reservas).

### LETRAS

El **juego de letras** consiste en la **generación aleatoria de una serie de letras**,
normalmente 9, con las que el jugador debe **construir una palabra válida del mayor
tamaño posible.**

### CLASES E INTERFACES

Modelo: **Comprobable** (*interface*), **XogoAzar** (*clase abstracta*), **XogoLetras**

Bases de datos: **ConexionDB**, **PalabraDAO**.

Aplicación gráfica Swing: **PanelLetras**, **VentaLetras**.

Aplicación: **AppXogoLetras**.

#### IMPORTANTE:

Haz la clase de **la aplicación al principio y vete haciendo pruebas con las clases
que vayas creando para comprobar que funciona el código**. Recuerda que el Netbeans
informa de los errores con mensajes en rojo. Sólo hay que leerlos para ver de qué se
trata.
