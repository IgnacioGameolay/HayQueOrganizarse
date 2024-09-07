# HayQueOrganizarse: Sistema de Gestión de Eventos en Java

## Descripción del programa

Este proyecto es un sistema de gestión de eventos desarrollado en Java utilizando NetBeans. Proporciona funcionalidades para gestionar eventos, y etiquetas. La aplicación ofrece a los usuarios multiples opciones que van desde crear eventos personalizados hasta exportar dichos eventos como un archivo.
## Funcionalidades

### Funcionando correctamente:

- Creación y gestión de eventos con atributos detallados (nombre, fecha, descripción, etc.).
- Asignar, modificar y eliminar etiquetas asociadas a eventos.
- Mostrar información detallada de todos los eventos y sus etiquetas.
- Buscar y mostrar eventos aplicando filtros variados (ID, día, semana, mes, y, etiquetas).
- Exportación de los eventos a un formato de archivo .txt (nombre a elección del usuario).

### Problemas conocidos:

- Ingreso de datos no válidos podría ocasionar errores en la ejecución, los cuales serán generalmente informados.
- La generación de reportes de eventos podría presentar fallos si la aplicación o proyecto no cuenta con los permisos necesarios.

### A mejorar:

- Incorporar una interfz gráfica de usuario (GUI) para mejorar la experiencia del usuario.
- Añadr notificaciones o recordatorios para eventos programados.

## Cómo compilar y ejecutar

Antes de configurar este proyecto, asegúrate de contar con los siguientes componentes instalados:

### Requisitos Previos:

1. **Java Development Kit (JDK) 8 o superior:** Asegúrate de que Java esté instalado y configurado correctamente en las variables de entorno de tu sistema.
2. **NetBeans IDE:** El proyecto está diseñado para ejecutarse con NetBeans, por lo que recomendamos ejecutar el proyecto desde dicho IDE. Si no tienes NetBeans lo puedes descargar desde el sitio oficial de [NetBeans](https://netbeans.apache.org/download/index.html).

### Guía de Instalación:

#### Paso 1: Clonar el Proyecto

Clona este repositorio en tu máquina local utilizando Git. Si no tienes Git instalado, puedes descargarlo desde el [sitio oficial de Git](https://git-scm.com/downloads). Para clonar el repositorio es tan fácil como pegar el siguiente comando en tu terminar GitBash:

```bash
git clone https://github.com/IgnacioGameolay/HayQueOrganizarse.git
```

#### Paso 2: Abrir el Proyecto en NetBeans

1. Abre NetBeans.
2. Ve a `File> Open Project (Ctrl+Shift+O)`.
3. Navega hasta la carpeta donde clonaste el repositorio y selecciona la carpeta del proyecto.
4. Seleccionas el archivo de nombre `HayQueOrganizarse`
5. Haz clic en "Abrir Proyecto".

#### Paso 3 (Opcional): Configurar el JDK

1. Haz clic derecho en el proyecto y selecciona `Properties`.
2. En la sección `Build> Compile`, verifica que la celda `Java Platform` esté configurada con un JDK 8 o superior.
3. Si no está configurado correctamente, selecciona el JDK adecuado desde el menú desplegable.

#### Paso 4: Ejecutar el Proyecto

Haz clic derecho en el proyecto y selecciona `Run` ó `Run Project`, también puedes presionar `F6` en tu teclado. Si todo está configurado correctamente, el proyecto se compilará y ejecutará sin problemas. En el caso que llegasen a haber inconvenientes con la compilación y ejecución del proyecto, un método alternativo sería que una vez agregados los archivos, hacer click derecho sobre el archivo del `Proyecto` en la jerarquía de archivos en NetBeans y seleccionar la opción `Clean and Build`, esto iniciará una compilación limpia desde cero, cuando finalice intenta volver a iniciar el proyecto.


## Ejemplo de uso

Al ejecutar el programa, se presentará un menú de opciones para gestionar los eventos. El usuario puede crear, modificar o eliminar eventos y participantes, además de asignarles etiquetas para mejorar la organización. Por ejemplo, al crear un nuevo evento, se solicitarán detalles como el nombre, fecha, ubicación y otros atributos. A continuación se deja una muestra del menú principal de nuestra apliación:
```
=== Menú de la Agenda ===
1. Agregar un evento
2. Mostrar todos los eventos
3. Editar evento por ID
4. Buscar eventos por día
5. Buscar eventos por semana
6. Buscar eventos por mes
7. Buscar eventos por etiqueta
8. Generar reporte de eventos
9. Salir
=========================
```