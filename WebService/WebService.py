# importamos los paquetes necesarios
from flask import Flask, Response, request, jsonify
import json
import Estructuras.Raiz_aeropuerto as raiz_aeropuertos
import Estructuras.Lista_aeropuerto as lista_aeropuetos
#utilizacion de flask
app = Flask(__name__)

#raices de las estructuras a utilizar
raiz_lista = None

#metodos que se utlilizaran para el manejo de la lista de aeropuertos
@app.route('/insertar_aereo', methods=['POST'])
def insertar_aero():
    lista = lista_aeropuetos.Lista_aeropuerto(raiz_lista)
    id = request.form['id']
    nombre = request.form['nombre']
    ciudad = request.form['ciudad']
    contra = request.form['contraseña']
    lista.insertar(id, nombre, ciudad, contra)
    return 'correcto'

@app.route('/ultimo_aereo', methods=['GET'])
def ultimo_aero():
    lista = lista_aeropuetos.Lista_aeropuerto(raiz_lista)
    ultimo = lista.devolver_ultimo()
    if (ultimo == 0):
        devolver = {'id':0}
        return json.dumps(devolver)
    else:
        return jsonify(id=ultimo)

@app.route('/imprimir_aereos', methods=['GET'])
def imprimir_aero():
    lista = lista_aeropuetos.Lista_aeropuerto(raiz_lista)
    retornar = lista.imprimir()
    return json.dumps(retornar)

if __name__ == '__main__':
    raiz_lista = raiz_aeropuertos.Raiz_aeropuerto()
    app.run(debug=True)

