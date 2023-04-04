# Payroll Module CLI

> Interfaz de Línea de Comandos de un Módulo de Nómina

## ACTIVIDAD DE TRANSFERENCIA DEL CONOCIMIENTO

Transportes Del Gran Caribe Colombiano SCA - TansCaribeCol, ha contratado a un grupo de
tres(3) personas para desarrollar un módulo sobre la nónima del personal de esta empresa,
en este caso se solicita que este módulo sea guardado a través de un archivo plano(\*.txt)
para luego la gerencia lo carga en un módulo para la confirmación y pago de salarios de
sus empleados y trabajadores oficiales.

Debe tener en cuenta un menú principal con los siguientes requerimientos:

1. El empleado si es **ADMINISTRATIVO**, tiene una asignación de _$20,000_ hora más
   prestaciones de ley. Si trabaja horas extras, la asignación será de _$25,000_ por hora
   extra trabajada y se tiene en cuenta para sus prestaciones. Importante: La ARL para los
   administrativos es Riesgo I (0,522%)

   Requiere que en volante de pago se imprima de la siguiente forma:

   ```text
   *************************************************
   **************** VOLANTE DE PAGO ****************
   *************************************************
   Nombre: Ana Maria Jaimes González
   Cargo: Auxiliar Administrativo
   Horas Trabajadas (mes): 40
   Salario Bruto: $800,000
   Horas Extras: 20
   Total pago Horas Extras: $500,000

   *************************************************
   *************** DESCUENTOS DE LEY ***************
   *************************************************
   Salud(4%): $52,000
   Pensión: $52,000
   ARL(0,522%): $6,786
   Total Descuentos: $104,000

   Total a pagar: $1,189,214

   *************************************************
   ************ FIN DEL VOLANTE DE PAGO ************
   *************************************************
   ```

2. El empleado si es **OPERATIVO** (Trabajador Oficial), tiene una asignación de _$40,000_ por
   hora pero debe cancelar de forma autónoma los aportes a la seguridad social teniendo
   en cuenta el cargo y las horas laboradas mensualmente:

   - Conductor: 160 horas mensuales
   - Oficios Generales: 100 horas mensuales
   - Vigilancia: 336 horas mensuales

3. Tenga en cuenta que los aportes a la Seguridad Social debe hallar el Índice Base de
   cotización que equivale al 40% y luego hallar los porcentajes correspondientes:

   - Salud: 12.5%
   - Pensión: 16%
   - ARL: De acuerdo al nivel del riesgo:
     - Oficios Generales equivale al Riesgo I: 0.522%
     - Conductor, Riesgo II: 1.044%
     - Vigilancia, Riesgo IV: 4.350%

   El volante debe ser similar a la opción pero no se tiene en cuenta las horas extras,
   teniendo en cuenta que este tipo de empleado está celebrando un contrato de prestación de
   servicios.

   La información debe mostrarse en una estructura de datos(Matriz, ArrayList) y que en el
   archivo TXT debe guardarlo de la siguiente forma:

   | Nombre                    | Tipo           | Cargo                   | HT  | Salario | HE  | TPHE   | Salud  | Pension | ARL  | Total a pagar |
   | ------------------------- | -------------- | ----------------------- | --- | ------- | --- | ------ | ------ | ------- | ---- | ------------- |
   | Ana María Jaimes González | ADMINISTRATIVO | Auxiliar Administrativo | 40  | 800000  | 20  | 500000 | 52000  | 52000   | 6786 | 1189124       |
   | Blanca Luz Iglesias Serpa | OPERATIVO      | Oficios Generales       | 100 | 4000000 | 0   | 0      | 200000 | 256000  | 8352 | 3535648       |

4. Actividades de evaluación
   | Evidencias de Aprendizaje | Criterios de Evaluación | Técnicas e Instrumentos de Evaluación |
   | ------------------------- | ----------------------- | ------------------------------------- |
   | **Evidencias de Desempeño:**<br>Demostración de un proceso de codificación de software de acuerdo a una situación problema planteada por el usuario.<br>**Evidencias de Producto:**<br>Valoración del funcionamiento de la aplicación y consultas generadas en el proyecto. | Realiza algoritmos utilizando atributos, objetos, métodos.<br>Utiliza las herramientas de programación orientadas a objetos, aplicando las funciones propias de los lenguajes de programación con sus respectivos stack de acuerdo con las necesidades del software.<br>Codifica los módulos del software siguiendo estándares de programación.<br>Genera las interfaces de captura y presentación de datos para el software. | **Técnica:** Valoración del producto.<br>**Instrumento de Evaluación:** Lista de chequeo de producto. |

5. Glosario de términos

   **Archivo:** Un archivo o fichero informático es un conjunto de bits que son almacenados en un dispositivo. Un archivo es identificado por un nombre y la descripción de la carpeta o directorio que lo contiene. A los archivos informáticos se les llama así porque son los equivalentes digitales de los archivos escritos en expedientes, tarjetas, libretas, papel o microfichas del entorno de oficina tradicional.

   **Algoritmo:** Es una serie de pasos organizados que describe el proceso que se debe seguir, para dar solución a un problema específico.

   **Código fuente:** Es un texto escrito en un lenguaje de programación para crear el programa. Es la forma del programa legible por el programador.

   **Constante:** Son valores que no cambian durante la ejecución de un algoritmo o programa.

   **Diagrama de flujo:** Representación gráfica, mediante la utilización de signos convencionales, del proceso que sigue la información en un programa determinado. Se utilizan habitualmente en la fase de desarrollo de aplicaciones por los programadores.

   **Estructuras de datos:** Es una forma de organizar un conjunto de datos elementales con el objetivo de facilitar su manipulación. Un dato elemental es la mínima información que se tiene en un sistema.

   **Funciones:** es un bloque de código que realiza una tarea o una función, este bloque de código se puede ejecutar llamando directamente el nombre de la función, una función puede ejecutar un bloque de código, también puede realizar una petición mediante parámetros y puede devolver un valor de acuerdo a la petición.

   **JAVA:** Lenguaje de programación creado por la empresa Oracle (antes Sun Microsystems) en 1991 para desarrollo de aplicaciones en formato escritorio y web.

   **Lenguaje natural:** Lenguaje utilizado normalmente por las personas. El objetivo de poder programar computadores utilizando lenguaje natural es una vieja idea que todavía no ha podido cumplirse, aunque los sistemas expertos y la inteligencia artificial podrán ayudar en este sentido.

   **LPP:** Es una herramienta de lógica de programación que fue creada como proyecto de graduación del Ing. Iván Deras el cual fue diseñado con la idea de facilitar el proceso de enseñanza – aprendizaje de un lenguaje de programación en nuestro idioma, este contiene la mayoría de instrucciones que tienen los lenguajes de programación.

   **Matrices:** Conjunto de variables (también llamado Bloque) del mismo tipo que el considerado en matemática, y cuyo acceso se realiza por índices o líneas.

   **Programa:** Redacción de un algoritmo en un lenguaje de programación.

   **Pseudocódigo:** Herramienta de análisis de programación. El pseudocódigo es un lenguaje de especificación de algoritmos, de uso fácil y sintaxis similar al lenguaje de programación a utilizar, que permite al programador concentrarse en las estructuras de control, y olvidarse de la sintaxis del lenguaje a utilizar.

   **Variable:** Se trata de una estructura matemática que puede almacenar cualquier tipo de información, ya sea numérica, alfanumérica, etc… Para entendernos, una variable podría ser como una caja, en la que puedes introducir cualquier cosa (información).

   **Vectores:** Lo habitual es que un vector tenga una cantidad fija de memoria asignada, aunque dependiendo del tipo vector y del lenguaje de programación un vector podría tener una cantidad variable de datos. En este caso, se les denomina vectores dinámicos, en oposición, a los vectores con una cantidad fija de memoria asignada los denomina vectores estáticos.
