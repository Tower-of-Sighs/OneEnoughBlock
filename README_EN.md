## One Enough Block
Does your modpack include three types of orange trees or four types of silver ore? Or do you want to remove useless naturally generated ores like copper ore?  
With this mod, you can easily specify replacing one block with another.

### Key Features
Path: `config/OEB/example.json`
```json
[
  {
    "match": [
      "manametalmod:ManaTreeLog",
      "#minecraft:logs"
    ],
    "result": "minecraft:redstone_block"
  },
  {
    "match": ["#minecraft:logs"],
    "result": "minecraft:redstone_block"
  }
]
```  
Write the IDs of the blocks you want to replace into a "match" list, and specify the target replacement block in the "result" field to enable automatic in-game replacement. Supports tag matching—replace all blocks under a tag with your target block.

### Use Cases
Block replacement occurs when creating a world or loading new chunks, making it ideal for naturally generated content like ores, plants, or specific blocks in structures.

It also applies to all scenarios where blocks are placed by players—replacements happen immediately upon placement.

Additionally, it can affect pre-placed blocks (e.g., replacing all existing blocks in an existing map). This feature is disabled by default and can be enabled via the configuration file.

### Future Plans
None currently.