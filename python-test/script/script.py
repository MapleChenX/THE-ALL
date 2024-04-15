import ollama

with open('img2.png', 'rb') as file:
    response = ollama.chat(
        model='llama2',  #llava
        messages=[
            {
                'role': 'user',
                'content': 'beautify this picture',
                'images': [file.read()],
            },
        ],
    )
    print(response['message']['content'])

