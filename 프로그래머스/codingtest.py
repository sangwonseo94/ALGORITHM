def solution(n, words):
    answer = []
    save =[]
    before_last_char = ""
    for index, word in enumerate(words):

        if ( index  == 0 ):
            before_last_char = word[len(word)-1]
            save.append(word)
        else:
            if(before_last_char == word[0]):
                before_last_char = word[len(word) - 1]
                if(word not in save):
                    save.append(word)
                else:
                    answer.append(index % n + 1)
                    answer.append(int(index / n + 1))
                    break;
            else:
                answer.append(int(index % n + 1))
                answer.append(int(index / n + 1))
                break;

    if(len(answer) == 0 ):
        answer.append(0)
        answer.append(0)
    print(save)
    return answer

print(solution(3,['tank', 'kick', 'know', 'wheel', 'land', 'dream', 'mother', 'robot', 'tank']))
print(solution(5,['hello', 'observe', 'effect', 'take', 'either', 'recognize', 'encourage', 'ensure', 'establish', 'hang', 'gather', 'refer', 'reference', 'estimate', 'executive']))
print(solution(2,['hello', 'one', 'even', 'never', 'now', 'world', 'draw']))