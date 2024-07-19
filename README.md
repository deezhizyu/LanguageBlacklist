# LanguageBlacklist
Simple Paper plugin for blacklisting certain languages. If the player has a blacklisted language selected in their settings, they will be kicked or banned.

### Config
| Value | Type | Description                                                                   | Default value |
|---|---|-------------------------------------------------------------------------------|---|
| `blacklist` | `List of strings` | List of blacklisted [in-game locale codes](https://minecraft.wiki/w/Language) | `[]` |
| `message` | `String` | Kick/ban message.                                                             | `"Your language settings is not allowed."` |
| `shouldBan` | `Boolean` | Should the player be banned for joining with a blacklisted language.          | `false` |

### Compile
LanguageBlacklist is built with  [Maven](https://maven.apache.org/). If you have it installed, just run `./maven package` in the root project folder.
