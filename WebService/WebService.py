# importamos los paquetes necesarios
from flask import Flask, request
import json
import Estructuras.Raiz_aeropuerto as raiz_aeropuertos
import Estructuras.Lista_aeropuerto as lista_aeropuetos
import Estructuras.Arbol_vuelos as arbol_vuelos
import Estructuras.Arbol_usuarios as arbol_usuarios

#utilizacion de flask
app = Flask(__name__)

#metodos que se utlilizaran para el manejo de la lista de aeropuertos
@app.route('/insertar_aereo', methods=['POST'])
def insertar_aero():
    id = request.form['id']
    nombre = request.form['nombre']
    ciudad = request.form['ciudad']
    contra = request.form['contraseña']
    lista.insertar(id, nombre, ciudad, contra)
    return 'correcto'

@app.route('/ultimo_aereo', methods=['GET'])
def ultimo_aero():
    ultimo = lista.devolver_ultimo()
    if (ultimo == 0):
        devolver = {'id':0}
        return json.dumps(devolver)
    else:
        devolver = {'id':ultimo}
        return json.dumps(devolver)

@app.route('/imprimir_aereos', methods=['GET'])
def imprimir_aero():
    retornar = lista.imprimir()
    return json.dumps(retornar)
@app.route('/graficar_aereos', methods=['GET'])
def graficar_aereos():
    codigo = lista.graficar()
    return codigo

###################metodo que utilizaremos para el manejo del arbol de vuelos#################
@app.route('/insertar_vuelo', methods=['POST'])
def insertar_vuelo():
    iden = request.form['id']
    lugar_salida = request.form['lugar salida']
    lugar_llegada = request.form['lugar llegada']
    hora_salida = request.form['hora salida']
    hora_llegada = request.form['hora llegada']
    fecha_salida = request.form['fecha salida']
    fecha_llegada = request.form['fecha llegada']
    cantidad_primera = request.form['cantidad primera clase']
    costo_primera = request.form['costo primera clase']
    cantidad_turista = request.form['cantidad primera clase']
    costo_turista = request.form['costo primera clase']
    cantidad_ejecutiva = request.form['cantidad clase ejecutiva']
    costo_ejecutiva = request.form['costo clase ejecutiva']
    estado_inicial = request.form['estado inicial']
    raiz_vuelos.crear_arbol(iden, lugar_salida,lugar_llegada,hora_salida,hora_llegada,fecha_salida,fecha_llegada,cantidad_primera,costo_primera,cantidad_ejecutiva,costo_ejecutiva,cantidad_turista,costo_turista,estado_inicial)
    return 'correcto'

@app.route('/imprimir_vuelos', methods=['GET'])
def imprimir_vuelo():
    retornar = raiz_vuelos.imprimir_vuelos()
    return json.dumps(retornar)

@app.route('/buscar_vuelo', methods=['POST'])
def buscar_vuelo():
    iden = request.form['id']
    retornar = raiz_vuelos.buscar_vuelo(iden)
    return json.dumps(retornar)
@app.route('/modificar_vuelo', methods=['POST'])
def modificar_vuelo():
    iden = request.form['id']
    hora_salida = request.form['hora salida']
    hora_llegada = request.form['hora llegada']
    fecha_salida = request.form['fecha salida']
    fecha_llegada = request.form['fecha llegada']
    cantidad_primera = request.form['cantidad primera clase']
    costo_primera = request.form['costo primera clase']
    cantidad_turista = request.form['cantidad primera clase']
    costo_turista = request.form['costo primera clase']
    cantidad_ejecutiva = request.form['cantidad clase ejecutiva']
    costo_ejecutiva = request.form['costo clase ejecutiva']
    estado = request.form['estado inicial']
    retornar = raiz_vuelos.modificar_vuelo(iden,hora_salida,hora_llegada,fecha_salida,fecha_llegada,cantidad_primera,costo_primera,cantidad_ejecutiva,costo_ejecutiva,cantidad_turista,costo_turista,estado)
    return retornar

@app.route('/graficar_arbol', methods=['GET'])
def graficar_arbol():
    raiz_vuelos.codigo ='digraph Arbol { \n'
    raiz_vuelos.graficar_arbol(raiz_vuelos.root)
    raiz_vuelos.codigo = raiz_vuelos.codigo + '}'
    return raiz_vuelos.codigo
############metodos que manejaremos para el uso del arbol de usuarios#####################
@app.route('/insertar_usuario', methods=['POST'])
def insertar_usuario():
    nombre = request.form['nombre']
    contrasena = request.form['contraseña']
    nickname = request.form['nickname']
    direccion = request.form['direccion']
    telefono = request.form['telefono']
    tarjeta_credito = request.form['tarjeta']
    direccion_actual = request.form['direccion actual']
    raiz_usuarios.crear_arbol(nombre,contrasena,nickname,direccion,telefono,tarjeta_credito,direccion_actual)
    return 'correcto'

@app.route('/imprimir_usuario', methods=['GET'])
def imprimir_usuario():
    retornar = raiz_usuarios.imprimir_usuarios()
    return json.dumps(retornar)

@app.route('/buscar_usuario', methods=['POST'])
def buscar_usuario():
    iden = request.form['id']
    retornar = raiz_usuarios.buscar_usuario(iden)
    return json.dumps(retornar)
@app.route('/modificar_usuario', methods=['POST'])
def modificar_usuarios():
    nombre = request.form['nombre']
    contrasena = request.form['contraseña']
    nickname = request.form['nickname']
    direccion = request.form['direccion']
    telefono = request.form['telefono']
    tarjeta_credito = request.form['tarjeta']
    direccion_actual = request.form['direccion actual']
    retornar = raiz_usuarios.modificar_usuario(nombre,contrasena,nickname,direccion,telefono,tarjeta_credito,direccion_actual)
    return retornar

@app.route('/graficar_arbol_usuarios', methods=['GET'])
def graficar_arbol_usuarios():
    raiz_usuarios.codigo ='digraph Arbol { \n'
    raiz_usuarios.graficar_arbol(raiz_usuarios.root)
    raiz_usuarios.codigo = raiz_usuarios.codigo + '}'
    return raiz_usuarios.codigo
#####METODO MAIN DEL WEB SERVICE######
if __name__ == '__main__':
    raiz_lista = raiz_aeropuertos.Raiz_aeropuerto()
    lista = lista_aeropuetos.Lista_aeropuerto(raiz_lista)
    raiz_vuelos = arbol_vuelos.Arbol_vuelos()
    raiz_usuarios = arbol_usuarios.Arbol_usuarios()
    app.run()

