# LibreriaApi
Esta librería funciona gracias al manejo del api Gutendex. La finalidad de esta es mostrar alguna información de los libros cargados en el api además de almacenarlos en una base de datos para futuras consultas.

Para ser más excato, esta aplicacion proporciona un menu al usuario en donde este podra elegir alguna de las opciones que se muestra en la siguiente imagen.

![Menu principal](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/5c00dd3b-167a-436d-b408-15e7ac923d93)

Como se puede ver, contamos con cinco opciones y la opcion de salida, pero analizaremos más a fondo el funcionamiento de cada una de estas.
Comencemos que la opcion buscar libro por titulo.

Al seleccionar esta opcion, la consola nos preguntara por el titulo del libro que desearemos buscar en la API, al ingresar el titulo, realizara una busqueda donde si el libro no
se encuentra, mostrara al usuario un mensaje de que el libro ingresado no se encuentra disponible, de lo contrario, imprimira en consola la informacion de esta y ademas sera almacenada
en la base de datos para su referencia más adelante ademas de abstraer la informacion recolectada y almacenar en una base de datos los datos
del autor para su referencia más adelante. El resultado de la opcion de busqueda del libro por titulo en la API es la siguiente:

![Opcion 1](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/feb13c7b-069d-4da9-bb52-561c5102cc7a)

![Almacenado en la BD 1](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/90ee6b06-2207-4796-8c42-b51db153917d)

![Almacenado en la BD 2](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/3884bac2-4d7b-45cb-9adb-c2fb37c5c102)

Como segunda opcion, contamos con lista de libros registrados, que sera encargada de mostrar en consola al usuario, todos los libros que se encuentran en la base de datos.
Como se puede ver en la siguiente imagen, muestra en consola los libros que se han buscado ademas de nuestro ejemplo utilizado en la primera opcion.

![Opcion listar libros](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/4314e4ba-3818-48cf-8ef1-8fd5f43885bb)

Como tercera opcio0n, contamos con listar autores registrados, que es similar a la opcion anterior. Con ayuda de la opcion uno, se extraen los datos del autor y se almacenan en la base de datos sin mostrar toda la infomacion detallada de estos en consola al seleccionar la opcion uno, pero en esta opcion es posible mostrar todos los autores de las busquedas hechas y mostrar la informacion completa de estos que es fecha de nacimiento y fecha de defunsion quedando de la siguiente manera.

![Opcion listar autores](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/7424dca7-eced-4f08-948c-673155a21043)

Como opcion cuatro, tenemos a listar autores vivos por fecha registrada, el cual se encargara de mostrar al usuario los autores que estaban vivos dependiendo la fecha ingresada por el usuario, por ejemplo, si hay algun autor que vivio de 1900 a 1980 y el usuario ingresara 1928, debe aparecer el autor, ya que estaba vivo en ese año. Todos estos datos son extraidos de la base de datos y son comparados para mostrar al usuario. La opcion cuatro queda de la siguiente forma:

![Opcion listar autores vivos por fecha  registrada](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/87a9de60-03e5-49e9-a3a0-2df5dab1ff0c)

Como quinta opcion se encuentra listar libros por idioma que se encarga de mostrar un sub menu con cuatro idiomas. Al seleccionar una opcion, muestra en la consola los libros que fueron registrados con
ese idioma. Asi es como queda el sub menu y el resultado de la opcion seleccionada.

![Sub menu](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/83e9d1d6-d947-4f21-9173-d72c970e9e5f)

Cabe mencionar que tanto este menu como el principal, se repetiran hasta que el usuario seleccione la opcion de salir.

Como ultima opcion contamos con la salida que se encarga de cerrar la aplicacion mostrando el siguiente mensaje al usuario.

![Salida](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/39925127-b1ea-4c1c-a8a8-f901f70f8c76)

Como puntos importantes, se tiene que si el usuario no coloca una opcion correcta en el menu principal o en el sub menu, se le mostrara un mensaje de error al usuario en consola, como el siguiente:

![Mensaje de error menu principal](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/4025c55d-fcd3-429a-bae3-a9bacfa4f2d4)

![Mensaje de error sub menu](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/1842c4a1-e943-4555-b419-2d37fca9db81)

Por ultimo y no menos importante, la base de datos tiene como nombre: biblioteca y se puede consultar desde el archivo: application.propierties.

![propiedades](https://github.com/JoelAlBe/LibreriaApi/assets/89107390/d382bd93-3766-4a4c-8a29-e6c7ad6b3cfc)







