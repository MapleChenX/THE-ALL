from fastapi import FastAPI
import time
import ollama

app = FastAPI()

response = ollama.chat(model='llama2', messages=[
    {
        'role': 'user',
        'content': 'Why is the sky blue?',
    },
])
print(response['message']['content'])

@app.get("/")
async def root():
    return {"message": "Hello World"}


@app.get("/hello/{name}")
async def say_hello(name: str):
    return {"message": f"Hello {name}"}


@app.get("/fuck/{name}")
def say_hello(name: str):
    return {"the person you wanna fuck is: ": f"Hello {name}"}


@app.get("/shit")
async def say_hello():
    time.sleep(5)
    return {"r u a piece of shit? ": "yes, indeed"}


@app.get("/ai")
async def generate(message: str = "Tell me a joke"):
    response = await ollama.chat(model='llama2', messages=[
        {
            'role': 'user',
            'content': 'Why is the sky blue?',
        },
    ])
    print(response['message']['content'])
    return response['message']['content']
