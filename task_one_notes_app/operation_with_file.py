import Note
import json

def save_note(notes):
    with open('/task_one_notes_app/note.json', 'w', encoding = 'utf-8') as file:
        json.dump([note.__dict__ for note in notes], file, indent = 4, separators=(',', ': '))

def read_notes():
    try:
        with open('/task_one_notes_app/note.json', 'r', encoding = 'utf-8') as file:
            data = json.load(file)
            notes = [Note.Note(**note) for note in data]
    except (json.decoder.JSONDecodeError, FileNotFoundError):
        notes = []
    return notes