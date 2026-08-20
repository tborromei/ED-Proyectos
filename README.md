# 🚀 Repositorio de Prueba: Aprendiendo Git y GitHub

¡Bienvenido a tu primer práctica de Git! 
El objetivo de este repositorio es que te familiarices con el flujo de trabajo básico utilizando Git y GitHub. 
Aquí podrás practicar comandos esenciales sin temor a romper nada.

## 🎯 Objetivos de la Práctica
* Clonar un repositorio remoto a tu computadora.
* Crear una rama propia para trabajar de forma segura.
* Realizar cambios en los archivos y registrar tus confirmaciones (commits).
* Subir tus cambios locales a GitHub (push).
* Experimentar con la sincronización de archivos (pull).

---

## 🛠️ Requisitos Previos
Antes de comenzar, asegúrate de tener instalado y configurado lo siguiente en tu equipo:
1. **Git**: Descárgalo desde [git-scm.com](https://git-scm.com) si aún no lo tienes.
2. **Una cuenta de GitHub**: Regístrate de forma gratuita en [github.com](https://github.com).
3. **Configuración inicial**: Abre tu terminal o consola y vincula tu identidad con estos comandos:
   ```bash
   git config --global user.name "Tu Nombre"
   git config --global user.email "tu-correo@ejemplo.com"
   ```

---

## 🚀 Guía Paso a Paso (Modo comando)

Sigue estos pasos en orden para completar la actividad práctica:

### Paso 1: Clonar el repositorio
Trae una copia exacta de este proyecto a tu computadora. Abre la terminal en la carpeta donde quieras guardarlo y ejecuta:
```bash
git clone <URL_DE_ESTE_REPOSITORIO>
```
*(Reemplaza `<URL_DE_ESTE_REPOSITORIO>` con el enlace HTTPS o SSH que encuentras en el botón verde "Code" de esta página).*

Entra a la carpeta del proyecto que se acaba de crear:
```bash
cd <NOMBRE_DE_LA_CARPETA>
```

### Paso 2: Crear una rama de trabajo
Para no alterar el código de la rama principal (`main`), crea una rama personalizada con tu nombre:
```bash
git checkout -b mi-primera-practica
```

### Paso 3: Realizar un cambio
1. Abre este proyecto en tu editor de código favorito (por ejemplo, VS Code).
2. Abre el archivo llamado `alumnos.txt` (si no existe, puedes crearlo).
3. Escribe tu nombre, apellido y un breve mensaje saludando al grupo.
4. Guarda el archivo.

### Paso 4: Revisar el estado y preparar el archivo
Verifica qué archivos han cambiado en tu entorno local:
```bash
git status
```
Añade el archivo modificado al área de preparación (Staging Area):
```bash
git add alumnos.txt
```

### Paso 5: Confirmar los cambios (Commit)
Guarda una foto instantánea de tus cambios con un mensaje descriptivo:
```bash
git commit -m "Añadido nombre de [Tu Nombre] a la lista de alumnos"
```

### Paso 6: Subir tus cambios a GitHub (Push)
Envía tu rama local con tus cambios hacia el servidor remoto en GitHub:
```bash
git push origin mi-primera-practica
```

### Paso 7: Comprobar el resultado
Regresa a la página de este repositorio en GitHub. Verás un aviso amarillo indicando que subiste una nueva rama. ¡Felicidades! Has completado con éxito el flujo básico de Git.

---

## 🧰 Acordeón de Comandos Útiles

| Comando | Qué hace |
| :--- | :--- |
| `git status` | Muestra el estado actual de tus archivos modificados. |
| `git log --oneline` | Muestra un historial corto de todos los commits realizados. |
| `git pull origin main` | Descarga y fusiona los últimos cambios del servidor a tu PC. |
| `git branch` | Lista todas las ramas locales de tu proyecto. |
