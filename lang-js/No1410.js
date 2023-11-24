/**
 * HTML 实体解析器
 * @param text
 * @returns {*}
 */
let entityParser = (text) => {
    return text.replaceAll('&quot;', '"')
        .replaceAll('&apos;', '\'')
        .replaceAll('&gt;', '>')
        .replaceAll('&lt;', '<')
        .replaceAll('&frasl;', '/')
        .replaceAll('&amp;', '&');
};
