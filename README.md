## One Enough Block
你的整合包中是否有三种橘子树或是四种银矿石？或者你想把铜矿石这样自然生成的无用矿石抹去？
通过本模组，你可以便利地指定将一种方块替换成另一种方块。

### 主要内容
路径：config/OEB/example.json
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

将需要替换的方块 ID 写进一个“match”列表，再将唯一指定代表方块填在“result”字段，即可在游戏中实现自动替换。

支持标签匹配，将一个标签下的所有方块都替换为目标方块。

### 使用场景

创建世界或加载新区块时，会进行方块替换，常用于自然生成方块如矿物、植物或结构中的特定方块。

方块替换也适用于其它所有放置方块的场景，玩家放置方块时也会立即发生替换。

此外，方块替换也可以作用于已放置的方块，如在已创建的地图中对所有已有方块进行替换，该功能默认不生效，可在配置文件中开启。

### 后续计划

暂无