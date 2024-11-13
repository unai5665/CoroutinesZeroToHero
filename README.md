# CoroutineZeroToHero

**CoroutineZeroToHero** es una aplicación Android que hace uso de **Kotlin**, **Coroutines** y **Retrofit** para realizar una solicitud HTTP a una API y mostrar una lista de usuarios. La aplicación está construida utilizando **Jetpack Compose** para la interfaz de usuario y sigue buenas prácticas de manejo de estado y concurrencia en Android.

## Tecnologías utilizadas

- **Kotlin**: Lenguaje de programación principal para el desarrollo de la aplicación.
- **Coroutines**: Para manejar operaciones asincrónicas de manera eficiente.
- **Retrofit**: Para realizar solicitudes HTTP y manejar respuestas JSON.
- **Jetpack Compose**: Para la construcción de interfaces de usuario declarativas.
- **Gson**: Para convertir los datos JSON en objetos Kotlin.
- **Android Studio**: IDE utilizado para el desarrollo de la aplicación.

## Características

- **Carga de datos**: La aplicación realiza una solicitud a la API `https://jsonplaceholder.typicode.com/users` para obtener una lista de usuarios.
- **Interfaz**: Los usuarios son mostrados en una lista en la interfaz.
- **Coroutines**: Se utilizan para realizar la carga de los datos de manera asíncrona, sin bloquear el hilo principal.

## Interfaz
![Interfaz de la aplicación]([images/screenshot.png](https://github.com/unai5665/CoroutinesZeroToHero/blob/master/listausuarios.png))



 **Link al repositorio**:
   git clone https://github.com/unai5665/CoroutineZeroToHero.git
