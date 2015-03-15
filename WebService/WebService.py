# importamos los paquetes necesarios
from flask import Flask, request
import json
import Estructuras.Raiz_aeropuerto as raiz_aeropuertos
import Estructuras.Lista_aeropuerto as lista_aeropuetos
#utilizacion de flask
app = Flask(__name__)

#raices de las estructuras a utilizar
raiz_lista = None

#metodos que se utlilizaran para el manejo de la lista de aeropuertos
@app.route('/insertar_avion', methods=['POST'])
def insertar_avion():
    lista = lista_aeropuetos.Lista_aeropuerto(raiz_lista)
    values = request.get_json()
    imprimir = values['id']
    return json.dumps(imprimir)

@app.route('/ultimo_avion', methods=['GET'])
def ultimo_avion():
    lista = lista_aeropuetos.Lista_aeropuerto(raiz_lista)
    ultimo = lista.devolver_ultimo()
    if ultimo == None:
        retorno = "{'id':'Lista_vacia'}"
        return json.dumps(retorno)
    else:
        retorno = "{'id':'"+ultimo+"'}"
        return json.dumps(retorno)

if __name__ == '__main__':
    raiz_lista = raiz_aeropuertos.Raiz_aeropuerto()
    app.run()

