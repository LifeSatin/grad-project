/** @type {import('./$types').PageLoad} */
export async function load({ fetch, params }) {
    console.log(params.slug);
	const res = await fetch(`http://backend:8080/discuss/board?boardId=${params.slug}`,  headers: {
        "Access-Control-Allow-Origin": "http://backend:8080",
    });
    const items = await res.json();
    console.log(params.slug);

    return { items, boardId: params.slug };
}